package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.service.ChargingStationService;
import fr.humanbooster.cda.dawid.totoenergy.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/charging-station")
@AllArgsConstructor
public class ChargingStationController {

    final ChargingStationService chargingStationService;
    private final FavoriteService favoriteService;

    @GetMapping
    public List<ChargingStation> showAllChargingStation() {
        return chargingStationService.list();
    }

}
