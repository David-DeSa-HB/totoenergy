package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HourlyRateDTO {
    @NotBlank(message = "required field")
    private Integer value;

    @NotBlank(message = "required field")
    private Float minimumDuration;
}
