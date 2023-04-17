package ru.redsoft.warships.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.redsoft.warships.mapper.CountryRowMapper;
import ru.redsoft.warships.persistence.Country;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepository {

    private final CountryRowMapper countryRowMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query("select * from COUNTRIES", countryRowMapper);
    }
}
