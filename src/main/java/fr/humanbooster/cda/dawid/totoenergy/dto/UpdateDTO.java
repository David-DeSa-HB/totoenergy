package fr.humanbooster.cda.dawid.totoenergy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDTO extends CreateDTO {

    private String phone;

    private LocalDate birthDate;
}
