package ru.redsoft.seabattles.repository.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.redsoft.seabattles.mapper.BattleMemberRowMapper;
import ru.redsoft.seabattles.persistence.BattleMember;
import ru.redsoft.seabattles.repository.BattleMembersRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BattleMembersRepositoryImpl implements BattleMembersRepository {

    private final BattleMemberRowMapper battleMemberRowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;


    private Optional<BattleMember> findById(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "select B_M.*, BATTLE_DATE from BATTLE_MEMBERS B_M\n" +
                        "join BATTLES B on B.BATTLE_NAME = B_M.BATTLE_NAME\n" +
                        "where B_M.ID = :id AND B_M.BATTLE_NAME = B.BATTLE_NAME",
                parameterSource,
                battleMemberRowMapper
        ));
    }

    @Override
    public List<BattleMember> findAll() {
        return jdbcTemplate.query(
                "select B_M.*, BATTLE_DATE from BATTLE_MEMBERS B_M\n" +
                "inner join BATTLES B on B.BATTLE_NAME = B_M.BATTLE_NAME\n" +
                "where B_M.BATTLE_NAME = B.BATTLE_NAME",
                battleMemberRowMapper
        );
    }

    @Override
    public Optional<BattleMember> save(BattleMember battleMember) {

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("warshipId", battleMember.getWarshipId())
                .addValue("battleName", battleMember.getBattleName())
                .addValue("resultForWarship", battleMember.getResultForWarship().toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update("insert into BATTLE_MEMBERS (WARSHIP_ID, BATTLE_NAME, RESULT_FOR_WARSHIP)" +
                " values(:warshipId, :battleName, :resultForWarship) returning ID", parameterSource, keyHolder);

        return this.findById(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    @Override
    public Optional<BattleMember> update(BattleMember battleMember) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", battleMember.getId())
                .addValue("warshipId", battleMember.getWarshipId())
                .addValue("battleName", battleMember.getBattleName())
                .addValue("resultForWarship", battleMember.getResultForWarship().toString());

        jdbcTemplate.update(
                "update BATTLE_MEMBERS set WARSHIP_ID = :warshipId, BATTLE_NAME = :battleName," +
                        " RESULT_FOR_WARSHIP = :resultForWarship where ID = :id",
                parameterSource
        );

        return this.findById(battleMember.getId());
    }

    public void delete(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update("delete from BATTLE_MEMBERS B_M where B_M.ID = :id", parameterSource);
    }
}
