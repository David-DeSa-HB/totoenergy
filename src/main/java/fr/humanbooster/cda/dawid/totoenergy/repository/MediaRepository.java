package fr.humanbooster.cda.dawid.totoenergy.repository;

import fr.humanbooster.cda.dawid.totoenergy.entity.HourlyRate;
import fr.humanbooster.cda.dawid.totoenergy.entity.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
    List<Media> findAllByChargingStationId(String chargingStationId);
}