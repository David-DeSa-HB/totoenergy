package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.ChargingStationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.entity.Localisation;
import fr.humanbooster.cda.dawid.totoenergy.repository.ChargingStationRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceListInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChargingStationService implements ServiceListInterface<ChargingStation, String>, ServiceUpdateInterface<ChargingStation, ChargingStationDTO, ChargingStationDTO, String> {

    private final ChargingStationRepository chargingStationRepository;
    private final LocalisationService localisationService;
    private final HourlyRateService hourlyRateService;

    @Override
    public ChargingStation create(ChargingStationDTO dto) {
        ChargingStation chargingStation = chargingStationFromDTO(new ChargingStation(), dto);
        chargingStation.setMedias(mediaService.addMedias());
        chargingStation.setHourlyRates(hourlyRateService.addhourlyRates());
        return chargingStationRepository.save(chargingStation);
    }

    @Override
    public void delete(ChargingStation chargingStation) {
        chargingStationRepository.delete(chargingStation);
    }

    @Override
    public List<ChargingStation> list() {
        return chargingStationRepository.findAll();
    }

    public List<ChargingStation> list(Localisation localisation) {
        return chargingStationRepository.findAll();
    }

    @Override
    public ChargingStation findOneById(String id) {
        return chargingStationRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public ChargingStation update(ChargingStationDTO dto, String id) {
        ChargingStation chargingStation = chargingStationFromDTO(this.findOneById(id), dto);
        return chargingStationRepository.save(chargingStation);
    }

    public ChargingStation chargingStationFromDTO(ChargingStation chargingStation, ChargingStationDTO dto) {
        chargingStation.setName(dto.getName());
        chargingStation.setAccessDirectives(dto.getAccessDirectives());
        chargingStation.setOnFoot(dto.getOnFoot());
        chargingStation.setPower(powerService.findOneById(dto.getPower()));
        chargingStation.setLocalisation(localisationService.findOneById(dto.getLocalisation()));
        return chargingStation;
    }
}