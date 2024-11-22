package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.UserCreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Role;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserRepository;
import fr.humanbooster.cda.dawid.totoenergy.dto.UserUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements ServiceGetInterface<User, String>, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User findOneById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findOneByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findOneByPrincipal(Principal principal) {
        return userRepository
                .findByEmail(principal.getName())
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findOneByActivationCode(String code) {
        System.out.println("UserService.findOneByActivationCode");
        System.out.println("code = " + code);
        return userRepository
                .findByActivationCode(code)
                .orElseThrow(() -> new NotFoundException("Ton truc marche pô"));
    }

    public User create(UserCreateDTO dto) {
        User user = userFromCreateDTO(new User(), dto);
        activationCode(user);
        return userRepository.saveAndFlush(user);
    }

    public User update(UserUpdateDTO dto, Principal principal) {
        User user = userFromUpdateDTO(this.findOneByPrincipal(principal), dto);
        return userRepository.saveAndFlush(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User userFromCreateDTO(User user, UserCreateDTO dto) {
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
        return user;
    }

    public User userFromUpdateDTO(User user, UserUpdateDTO dto) {
        userFromCreateDTO(user, dto);
        user.setPhone(dto.getPhone());
        user.setBirthDate(dto.getBirthDate());
        return user;
    }

    public void activationCode(User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        user.setActivationCodeSentAt(LocalDateTime.now());
    }

    public User activateUser(String code) {
        User user = findOneByActivationCode(code);
        user.setActivationCode(null);
        return userRepository.saveAndFlush(user);
    }

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