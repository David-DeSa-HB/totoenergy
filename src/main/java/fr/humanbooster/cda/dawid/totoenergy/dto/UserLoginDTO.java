package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {

    @NotBlank(message = "required field")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "required field")
    private String password;
}
