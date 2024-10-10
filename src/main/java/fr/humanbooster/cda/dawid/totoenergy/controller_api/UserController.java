package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.UserUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User showUser(@PathVariable String id) {
        return userService.findOneById(id);
    }

//    @PostMapping
//    public User createUser(@Valid @RequestBody UserCreateDTO dto) {
//        return userService.create(dto);
//    }

    @PutMapping("/{id}")
    public void updateUserById(
            @PathVariable String id,
            @Valid @RequestBody UserUpdateDTO dto) {
        if (id != null) {
            userService.update(dto, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable String id) {
        if (id != null) {
            userService.delete(userService.findOneById(id));
        }
    }

}