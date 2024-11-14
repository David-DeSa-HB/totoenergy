package fr.humanbooster.cda.dawid.totoenergy.dto;

import fr.humanbooster.cda.dawid.totoenergy.validation.constrain.LegitPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {

    @Email(message = "invalid email")
    @NotBlank(message = "required field")
    public String email;

    @NotBlank(message = "required field")
    @LegitPassword(message = "password must contain * and at least 5 characters")
    public String password;

    @NotBlank(message = "required field")
    public String lastName;

    @NotBlank(message = "required field")
    public String firstName;
}
