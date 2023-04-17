package ru.redsoft.seabattles.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.redsoft.seabattles.mapper.BattleRowMapper;
import ru.redsoft.seabattles.persistence.Battle;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BattleRepositoryImpl implements BattleRepository {

    private final BattleRowMapper battleRowMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private Optional<Battle> findByName(String battleName) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("battleName", battleName);

        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "select * from BATTLES where BATTLE_NAME = :battleName",
                parameterSource,
                battleRowMapper
        ));
    }

    @Override
    public List<Battle> findAll() {
        return jdbcTemplate.query("select * from BATTLES", battleRowMapper);
    }

    @Override
    public Optional<Battle> save(Battle battle) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("battleName", battle.getBattleName())
                .addValue("battleDate", Timestamp.from(battle.getBattleDate()));

        jdbcTemplate.update("insert into BATTLES values(:battleName, :battleDate)", parameterSource);

        return this.findByName(battle.getBattleName());
    }

}
