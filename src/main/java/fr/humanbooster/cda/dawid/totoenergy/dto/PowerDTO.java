package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PowerDTO {
    @NotBlank(message = "required field")
    private Float value;
}
