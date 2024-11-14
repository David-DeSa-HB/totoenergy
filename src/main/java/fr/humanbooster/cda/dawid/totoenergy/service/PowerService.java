package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.repository.PowerRepository;
import fr.humanbooster.cda.dawid.totoenergy.dto.PowerDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Power;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PowerService implements ServiceGetInterface<Power, Long>, ServiceUpdateInterface<Power, PowerDTO, PowerDTO, Long> {

    private final PowerRepository powerRepository;

    @Override
    public Power findOneById(Long id) {
        return powerRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Power create(PowerDTO dto) {
        Power power = powerFromDTO(new Power(), dto);
        return powerRepository.saveAndFlush(power);
    }

    @Override
    public Power update(PowerDTO dto, Long id) {
        Power power = powerFromDTO(this.findOneById(id), dto);
        return powerRepository.saveAndFlush(power);
    }

    @Override
    public void delete(Power power) {
        powerRepository.delete(power);
    }

    public Power powerFromDTO(Power power, PowerDTO dto) {
        power.setValue(dto.getValue());
        return power;
    }

}