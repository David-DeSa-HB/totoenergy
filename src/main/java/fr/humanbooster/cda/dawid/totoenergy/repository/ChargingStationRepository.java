package fr.humanbooster.cda.dawid.totoenergy.repository;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, String> {

}