package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.response.JwtResponse;
import fr.humanbooster.cda.dawid.totoenergy.security.JwtAuthenticatorService;
import fr.humanbooster.cda.dawid.totoenergy.service.UserService;
import fr.humanbooster.cda.dawid.totoenergy.dto.LoginDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.CreateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/register")
    public User updateSecurityById(@Valid @RequestBody CreateDTO dto) {
        return userService.create(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> securityService(@Valid @RequestBody LoginDTO dto) {
        return jwtAuthenticatorService.authenticate(dto);
    }
}
