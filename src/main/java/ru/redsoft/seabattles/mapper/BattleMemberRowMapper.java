package ru.redsoft.seabattles.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.persistence.BattleMember;
import ru.redsoft.seabattles.persistence.BattleResultForWarship;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BattleMemberRowMapper implements RowMapper<BattleMember> {


    @Override
    public BattleMember mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BattleMember(
                rs.getLong("ID"),
                rs.getLong("WARSHIP_ID"),
                rs.getString("BATTLE_NAME"),
                BattleResultForWarship.valueOf(rs.getString("RESULT_FOR_WARSHIP"))
        );
    }
}
