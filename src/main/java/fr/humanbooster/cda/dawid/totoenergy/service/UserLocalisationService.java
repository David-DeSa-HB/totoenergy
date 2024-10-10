package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.UserLocalisationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.UserLocalisation;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserLocalisationRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceCreateDeleteInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserLocalisationService implements ServiceListInterface<UserLocalisation, Long>, ServiceCreateDeleteInterface<UserLocalisation, UserLocalisationDTO> {

    private final UserLocalisationRepository userLocalisationRepository ;

    @Override
    public UserLocalisation create(UserLocalisationDTO userLocalisationDTO) {
        return null;
    }

    @Override
    public void delete(UserLocalisation object) {

    }

    @Override
    public List<UserLocalisation> list() {
        return List.of();
    }

    @Override
    public UserLocalisation findOneById(Long id) {
        return userLocalisationRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}