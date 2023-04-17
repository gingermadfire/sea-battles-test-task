package ru.redsoft.warships.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.redsoft.warships.persistence.Country;
import ru.redsoft.warships.persistence.Side;

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
