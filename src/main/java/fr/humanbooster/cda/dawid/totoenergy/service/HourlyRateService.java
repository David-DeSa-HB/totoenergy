package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.HourlyRateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.entity.HourlyRate;
import fr.humanbooster.cda.dawid.totoenergy.repository.HourlyRateRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HourlyRateService implements ServiceGetInterface<HourlyRate, Long>, ServiceUpdateInterface<HourlyRate, HourlyRateDTO, HourlyRateDTO, Long> {

    private final HourlyRateRepository hourlyRateRepository;

    @Override
    public HourlyRate create(HourlyRateDTO dto) {
        HourlyRate hourlyRate = hourlyRateFromDTO(new HourlyRate(), dto);
        return hourlyRateRepository.save(hourlyRate);
    }

    @Override
    public void delete(HourlyRate hourlyRate) {
        hourlyRateRepository.delete(hourlyRate);
    }

    @Override
    public HourlyRate findOneById(Long id) {
        return hourlyRateRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public HourlyRate update(HourlyRateDTO dto, Long id) {
        HourlyRate hourlyRate = hourlyRateFromDTO(this.findOneById(id), dto);
        return hourlyRateRepository.save(hourlyRate);
    }

    public HourlyRate hourlyRateFromDTO(HourlyRate hourlyRate, HourlyRateDTO dto) {
        hourlyRate.setValue(dto.getValue());
        hourlyRate.setMinimumDuration(dto.getMinimumDuration());
        return hourlyRate;
    }

    public List<HourlyRate> addHourlyRate(ChargingStation chargingStation, HourlyRateDTO dto){
        List<HourlyRate> hourlyRates = hourlyRateRepository.findAllByChargingStationId(chargingStation.getId());
        if (hourlyRates == null){
            hourlyRates = new ArrayList<>();
        }
        hourlyRates.add(create(dto));
        return hourlyRates;
    }
}