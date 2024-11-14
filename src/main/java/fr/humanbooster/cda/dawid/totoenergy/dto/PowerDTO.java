package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PowerDTO {
    @NotNull(message = "required field")
    private Float value;
}
