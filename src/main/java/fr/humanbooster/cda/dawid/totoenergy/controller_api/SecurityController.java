package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.UserActivationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.response.JwtResponse;
import fr.humanbooster.cda.dawid.totoenergy.security.JwtAuthenticatorService;
import fr.humanbooster.cda.dawid.totoenergy.service.UserService;
import fr.humanbooster.cda.dawid.totoenergy.dto.UserLoginDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.UserCreateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserCreateDTO dto) {
        return userService.create(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@Valid @RequestBody UserLoginDTO dto) {
        return jwtAuthenticatorService.authenticate(dto);
    }

    @PutMapping("/activate")
    public User activateUser(@RequestBody UserActivationDTO code){
        return userService.activateUser(code.getCode());
    }
}
