package ru.redsoft.seabattles.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.persistence.Country;
import ru.redsoft.seabattles.persistence.Side;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country(
                rs.getString("NAME"),
                Side.valueOf(rs.getString("SIDE"))
        );
    }

}
