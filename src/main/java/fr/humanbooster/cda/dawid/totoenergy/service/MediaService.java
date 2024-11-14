package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.repository.MediaRepository;
import fr.humanbooster.cda.dawid.totoenergy.dto.MediaDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Media;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceListInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MediaService implements ServiceListInterface<Media, String>,
        ServiceUpdateInterface<Media, MediaDTO, MediaDTO, String> {

    private final MediaRepository mediaRepository;

    @Override
    public Media findOneById(String id) {
        return mediaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Media> list() {
        return mediaRepository.findAll();
    }

    @Override
    public Media create(MediaDTO dto) {
        Media media = MediaFromDTO(new Media(), dto);
        return mediaRepository.saveAndFlush(media);
    }

    @Override
    public Media update(MediaDTO dto, String id) {
        Media media = MediaFromDTO(this.findOneById(id), dto);
        return mediaRepository.saveAndFlush(media);
    }

    @Override
    public void delete(Media media) {
        mediaRepository.delete(media);
    }

    public Media MediaFromDTO(Media media, MediaDTO dto) {
        media.setName(dto.getName());
        media.setExtension(dto.getExtension());
        return media;
    }

    public List<Media> addMedia(ChargingStation chargingStation, MediaDTO dto){
        List<Media> medias = mediaRepository.findAllByChargingStationId(chargingStation.getId());
        if (medias == null){
            medias = new ArrayList<>();
        }
        medias.add(create(dto));
        return medias;
    }
}