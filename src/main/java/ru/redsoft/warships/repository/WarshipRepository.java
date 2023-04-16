package ru.redsoft.warships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.redsoft.warships.persistence.Warship;

import java.util.Optional;

@Repository
public interface WarshipRepository extends JpaRepository<Warship, String> {

    Optional<Warship> findByName(String name);
}
