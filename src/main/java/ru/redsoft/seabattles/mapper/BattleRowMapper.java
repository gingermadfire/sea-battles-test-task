package ru.redsoft.seabattles.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.persistence.Battle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class BattleRowMapper implements RowMapper<Battle> {

    @Override
    public Battle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Battle(
                rs.getString("BATTLE_NAME"),
                rs.getObject("BATTLE_DATE", Timestamp.class).toInstant()
        );
    }

}
