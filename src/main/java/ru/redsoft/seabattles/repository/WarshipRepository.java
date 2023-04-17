package ru.redsoft.seabattles.repository;

import ru.redsoft.seabattles.persistence.Warship;

import java.util.List;
import java.util.Optional;

public interface WarshipRepository {

    Optional<Warship> findById(Long id);

    List<Warship> findAll();
}
