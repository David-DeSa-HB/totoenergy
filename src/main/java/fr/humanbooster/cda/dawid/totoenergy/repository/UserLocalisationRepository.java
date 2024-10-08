package fr.humanbooster.cda.dawid.totoenergy.repository;

import fr.humanbooster.cda.dawid.totoenergy.entity.UserLocalisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocalisationRepository extends JpaRepository<UserLocalisation, Long> {

}