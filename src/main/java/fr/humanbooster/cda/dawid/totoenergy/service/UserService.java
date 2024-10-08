package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.CreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Role;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserRepository;
import fr.humanbooster.cda.dawid.totoenergy.dto.UpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements ServiceUpdateInterface<User, CreateDTO, UpdateDTO, String>, ServiceGetInterface<User, String>, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User findOneById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User create(CreateDTO dto) {
        User user = UserFromCreateDTO(new User(), dto);
        ActivationCode(user);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(UpdateDTO dto, String id) {
        User user = UserFromUpdateDTO(this.findOneById(id), dto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User UserFromCreateDTO(User user, CreateDTO dto) {
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
        return user;
    }

    public User UserFromUpdateDTO(User user, UpdateDTO dto) {
        UserFromCreateDTO(user, dto);
        user.setPhone(dto.getPhone());
        user.setBirthDate(dto.getBirthDate());
        return user;
    }

    public User ActivationCode(User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        user.setActivationCodeSentAt(LocalDateTime.now());
        return user;
    }

    public void activateUser(String code){
        User user = findOneByActivationCode(code);
        user.setActivationCode(null);
    }

    private User findOneByActivationCode(String code) {
        return userRepository
                .findByActivationCode(code)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connexion Impossible"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getGrantedAuthority(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("roles = " + roles);
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getLabel())));
        System.out.println("authorities = " + authorities);
        return authorities;
    }
}