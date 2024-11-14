package fr.humanbooster.cda.dawid.totoenergy.repository;

import fr.humanbooster.cda.dawid.totoenergy.entity.Power;

import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {
}