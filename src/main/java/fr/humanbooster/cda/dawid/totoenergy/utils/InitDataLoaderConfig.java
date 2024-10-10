package fr.humanbooster.cda.dawid.totoenergy.utils;

import fr.humanbooster.cda.dawid.totoenergy.entity.Role;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.repository.RoleRepository;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserRepository;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        createRoles();
        createUsers();
    }

    private void createRoles() {
        if (roleRepository.count() == 0) {
            Role userRole = new Role();
            userRole.setLabel("ROLE_USER");
            roleRepository.saveAndFlush(userRole);

            Role adminRole = new Role();
            adminRole.setLabel("ROLE_ADMIN");
            roleRepository.saveAndFlush(adminRole);

            Role superAdminRole = new Role();
            superAdminRole.setLabel("ROLE_SUPER_ADMIN");
            roleRepository.saveAndFlush(superAdminRole);
        }
    }

    private void createUsers() {
        Faker faker = new Faker(Locale.of("fr"));
        List<String> duplicates = new ArrayList<>();
        long count = 50 - userRepository.count();
        for (long i = 1L; i <= count; i++) {
            User user = new User();
            String firstName;
            do {
                firstName = faker.name().lastName();
            } while (duplicates.contains(firstName));
            duplicates.add(firstName);
            user.setFirstName(firstName);

            String lastName = faker.name().lastName();
            user.setLastName(lastName);

            String email = (firstName+lastName).replaceAll(" ", "") + "@toto.toto";
            user.setPassword(passwordEncoder.encode("12345*"));
            user.setActivationCodeSentAt(generateRandomDateTime());
            user.setEmail(email);
            user.setBirthDate(generateRandomDate(18, 36, 356));

            Role userRole = roleRepository.findById(1L).get();
            Role admin = roleRepository.findById(2L).get();
            Role superAdmin = roleRepository.findById(3L).get();
            if (i == 1L) {
                user.setRoles(List.of(superAdmin, admin, userRole));
            } else if (i == 2L) {
                user.setRoles(List.of(admin, userRole));
            } else
            {
                user.setRoles(List.of(userRole));
            }
            userRepository.save(user);
        }
    }

    private LocalDateTime generateRandomDateTime() {
        Faker faker = new Faker();
        Instant randomDate = faker.timeAndDate().between(
                Instant.now().minusMillis(999999999),
                Instant.now());
        return randomDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private LocalDate generateRandomDate(Integer min, Integer max, Integer random) {
        int years = new Random().nextInt(max-min) + min;
        int days = new Random().nextInt(random);
        return LocalDate.now().minusYears(years).minusDays(days);
    }


}
