package fr.humanbooster.cda.dawid.totoenergy.repository;

import fr.humanbooster.cda.dawid.totoenergy.entity.HourlyRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourlyRateRepository extends JpaRepository<HourlyRate, Long> {
    List<HourlyRate> findAllByChargingStationId(String chargingStationId);
}