package ru.redsoft.seabattles.repository;

import ru.redsoft.seabattles.persistence.BattleMember;

import java.util.List;
import java.util.Optional;

public interface BattleMembersRepository {

     List<BattleMember> findAll();

     Optional<BattleMember> save(BattleMember battleMember);

     Optional<BattleMember> update(BattleMember battleMember);


}
