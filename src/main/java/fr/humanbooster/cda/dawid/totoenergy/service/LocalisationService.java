package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.dto.LocalisationDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Localisation;
import fr.humanbooster.cda.dawid.totoenergy.repository.LocalisationRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceGetInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalisationService implements ServiceGetInterface<Localisation, Long>, ServiceUpdateInterface<Localisation, LocalisationDTO, LocalisationDTO, Long> {

    private final LocalisationRepository localisationRepository;


    @Override
    public Localisation create(LocalisationDTO dto) {
        Localisation localisation = localisationFromDTO(new Localisation(), dto);
        return localisationRepository.save(localisation);
    }

    @Override
    public void delete(Localisation localisation) {
        localisationRepository.delete(localisation);
    }

    @Override
    public Localisation findOneById(Long id) {
        return localisationRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Localisation update(LocalisationDTO dto, Long id) {
        Localisation localisation = localisationFromDTO(this.findOneById(id), dto);
        return localisationRepository.save(localisation);
    }

    public Localisation localisationFromDTO(Localisation localisation, LocalisationDTO dto) {
        localisation.setStreetNumber(dto.getStreetNumber());
        localisation.setStreetName(dto.getStreetName());
        localisation.setCity(dto.getCity());
        localisation.setZipCode(dto.getZipCode());
        localisation.setLatitude(dto.getLatitude());
        localisation.setLongitude(dto.getLongitude());
        return localisation;
    }
}