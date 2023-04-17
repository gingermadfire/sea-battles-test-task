package ru.redsoft.seabattles.repository;

import ru.redsoft.seabattles.persistence.Battle;

import java.util.List;
import java.util.Optional;

public interface BattleRepository {

    List<Battle> findAll();

    Optional<Battle> save(Battle battle);
}
