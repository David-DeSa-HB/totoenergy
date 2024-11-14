package fr.humanbooster.cda.dawid.totoenergy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MediaDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String extension;

}
