package ru.redsoft.seabattles.repository;

import ru.redsoft.seabattles.persistence.Battle;

import java.util.List;
import java.util.Optional;

public interface BattleRepository {

    Optional<Battle> findByName(String name);

    List<Battle> findAll();

    Optional<Battle> save(Battle battle);
}
