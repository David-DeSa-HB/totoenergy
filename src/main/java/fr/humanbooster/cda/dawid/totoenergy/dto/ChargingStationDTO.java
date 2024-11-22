package fr.humanbooster.cda.dawid.totoenergy.dto;

import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargingStationDTO {

    @NotBlank(message = "required field")
    private String name;

    private String accessDirectives;

    @NotBlank(message = "required field")
    private Boolean onFoot;

    @NotBlank(message = "required field")
    private Long power;

    @NotBlank(message = "required field")
    private Long Localisation;

    private HourlyRateDTO hourlyRateDto;

    private MediaDTO mediaDto;

}
