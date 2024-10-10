package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.LocalisationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Localisation;
import fr.humanbooster.cda.dawid.totoenergy.service.LocalisationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localisation")
@AllArgsConstructor
public class LocalisationController {

    private final LocalisationService localisationService;

    @GetMapping("/{id}")
    public Localisation showLocalisation(@PathVariable Long id) {
        return localisationService.findOneById(id);
    }

    @PostMapping
    public Localisation createLocalisation(@RequestBody LocalisationDTO dto) {
        return localisationService.create(dto);
    }

    @PutMapping("/{id}")
    public Localisation updateLocalisation(@PathVariable Long id, @RequestBody LocalisationDTO dto) {
        return localisationService.update(dto, id);
    }
}
