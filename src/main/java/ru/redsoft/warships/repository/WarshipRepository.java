package ru.redsoft.warships.repository;

import ru.redsoft.warships.persistence.Warship;

import java.util.List;
import java.util.Optional;

public interface WarshipRepository {

    Optional<Warship> findById(Long id);

    List<Warship> findAll();
}
