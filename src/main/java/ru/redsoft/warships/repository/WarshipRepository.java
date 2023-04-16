package ru.redsoft.warships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.redsoft.warships.persistence.Warships;

@Repository
public interface WarshipsRepository extends JpaRepository<Warships, String> {
}
