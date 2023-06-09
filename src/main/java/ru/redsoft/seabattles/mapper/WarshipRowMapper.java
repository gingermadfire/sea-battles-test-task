package ru.redsoft.seabattles.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.persistence.Warship;
import ru.redsoft.seabattles.persistence.WarshipClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class WarshipRowMapper implements RowMapper<Warship> {

    @Override
    public Warship mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Warship(
                rs.getLong("ID"),
                rs.getString("NAME"),
                WarshipClass.valueOf(rs.getString("CLASS")),
                rs.getObject("COMMISSION_DATE", Timestamp.class).toInstant(),
                rs.getObject("DECOMMISSION_DATE", Timestamp.class).toInstant()
        );
    }

}
