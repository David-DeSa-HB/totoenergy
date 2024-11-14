package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.entity.Power;
import fr.humanbooster.cda.dawid.totoenergy.service.PowerService;
import fr.humanbooster.cda.dawid.totoenergy.dto.PowerDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/power")
@AllArgsConstructor
public class PowerController {

    private final PowerService powerService;

    @GetMapping("/{id}")
    public Power findPowerBySearch(@PathVariable Long id) {
        return powerService.findOneById(id);
    }

    @PostMapping
    public Power powerService(@Valid @RequestBody PowerDTO dto) {
        return powerService.create(dto);
    }

    @PutMapping("/{id}")
    public void updatePowerById(
            @PathVariable Long id,
            @Valid @RequestBody PowerDTO dto) {
        if (id != null) {
            powerService.update(dto, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePowerByID(@PathVariable Long id) {
        if (id != null) {
            powerService.delete(powerService.findOneById(id));
        }
    }
}