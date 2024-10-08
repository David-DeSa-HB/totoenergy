package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.UpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.service.UserService;
import fr.humanbooster.cda.dawid.totoenergy.dto.CreateDTO;
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

    @PostMapping
    public User createUser(@Valid @RequestBody CreateDTO dto) {
        return userService.create(dto);
    }

    @PostMapping("/activate")
    public void activateUser(@RequestBody String code) {
        userService.activateUser(code);
    }

    @PutMapping("/{id}")
    public void updateUserById(
            @PathVariable String id,
            @Valid @RequestBody UpdateDTO dto) {
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