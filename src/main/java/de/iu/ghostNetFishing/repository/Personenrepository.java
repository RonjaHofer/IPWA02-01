package de.iu.ghostNetFishing.repository;

import de.iu.ghostNetFishing.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Personenrepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByVornameAndNachname(String vorname, String nachname);
}
