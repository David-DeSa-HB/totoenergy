package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.LocalisationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.HourlyRate;
import fr.humanbooster.cda.dawid.totoenergy.entity.Localisation;
import fr.humanbooster.cda.dawid.totoenergy.service.HourlyRateService;
import fr.humanbooster.cda.dawid.totoenergy.dto.HourlyRateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hourlyRate")
@AllArgsConstructor
public class HourlyRateController {

    private final HourlyRateService hourlyRateService;

    @GetMapping("/{id}")
    public HourlyRate findHourlyRateById(@PathVariable Long id) {
        return hourlyRateService.findOneById(id);
    }

    @PostMapping
    public HourlyRate createHourlyRate(@Valid @RequestBody HourlyRateDTO dto) {
        return hourlyRateService.create(dto);
    }

    @PutMapping("/{id}")
    public HourlyRate updateHourlyRate(@PathVariable Long id, @RequestBody HourlyRateDTO dto) {
        return hourlyRateService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHourlyRate(@PathVariable Long id) {
        if (id != null) {
            hourlyRateService.delete(hourlyRateService.findOneById(id));
        }
    }

}