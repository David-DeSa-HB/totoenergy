package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.cda.dawid.totoenergy.dto.UserCreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.UserUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.service.UserService;
import fr.humanbooster.cda.dawid.totoenergy.utils.JsonViews;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @JsonView(JsonViews.ViewsUserMinimal.class)
    @GetMapping("/id/{id}")
    public User showUserById(@PathVariable String id) {
        return userService.findOneById(id);
    }

//    @JsonView(JsonViews.ViewsUserMinimal.class)
//    @GetMapping("/email/{email}")
//    public User showUserByEmail(@PathVariable String email) {
//        return userService.findOneByEmail(email);
//    }

    @JsonView(JsonViews.ViewsUserDetails.class)
    @GetMapping("/me")
    public User showLoggedUser(@AuthenticationPrincipal UserDetails principal) {
        return userService.findOneByEmail(principal.getUsername());
    }

    @JsonView(JsonViews.ViewsUserDetails.class)
    @PostMapping
    public User createUser(@Valid @RequestBody UserCreateDTO dto) {
        return userService.create(dto);
    }

    @JsonView(JsonViews.ViewsUserDetails.class)
    @PutMapping("/me")
    public void updateUserById(
            Principal principal,
            @Valid @RequestBody UserUpdateDTO dto) {
        if (principal != null) {
            userService.update(dto, principal.getName());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable String id) {
        if (id != null) {
            userService.delete(userService.findOneById(id));
        }
    }
}