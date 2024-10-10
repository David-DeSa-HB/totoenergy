package fr.humanbooster.cda.dawid.totoenergy.dto;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.entity.UserLocalisation;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalisationDTO {

    private String streetNumber;

    @NotBlank(message = "required field")
    private String streetName;

    private String latitude;

    private String longitude;

    @NotBlank(message = "required field")
    private String zipCode;

    @NotBlank(message = "required field")
    private String city;
}
