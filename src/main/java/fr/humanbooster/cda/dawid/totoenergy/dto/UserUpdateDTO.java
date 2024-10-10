package fr.humanbooster.cda.dawid.totoenergy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO extends UserCreateDTO {

    private String phone;

    private LocalDate birthDate;
}
