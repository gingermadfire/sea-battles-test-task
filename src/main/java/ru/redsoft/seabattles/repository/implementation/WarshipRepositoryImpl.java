package ru.redsoft.seabattles.repository.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.redsoft.seabattles.mapper.WarshipRowMapper;
import ru.redsoft.seabattles.persistence.Warship;
import ru.redsoft.seabattles.repository.WarshipRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WarshipRepositoryImpl implements WarshipRepository {

    private final WarshipRowMapper warshipRowMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<Warship> findById(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        return Optional.ofNullable(
                jdbcTemplate
                        .queryForObject("select * from WARSHIPS where id = :id", parameterSource, warshipRowMapper));
    }

    @Override
    public List<Warship> findAll() {
        return jdbcTemplate.query("select * from WARSHIPS", warshipRowMapper);
    }


}
