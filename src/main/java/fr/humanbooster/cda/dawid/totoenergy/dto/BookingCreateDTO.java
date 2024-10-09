package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingCreateDTO extends CreateDTO {

    @NotBlank(message = "required field")
    private LocalDate startedAt;

    @NotBlank(message = "required field")
    private LocalDate finishedAt;

    @NotBlank(message = "required field")
    private Long chargingStation;

    @NotBlank(message = "required field")
    private Long userLocalisation;
}
