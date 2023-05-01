package ru.redsoft.seabattles.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.exchange.request.BattleMemberRequest;
import ru.redsoft.seabattles.exchange.response.BattleMemberFindAllResponse;
import ru.redsoft.seabattles.exchange.response.BattleMemberResponse;
import ru.redsoft.seabattles.exchange.response.BattleResponse;
import ru.redsoft.seabattles.exchange.response.WarshipResponse;
import ru.redsoft.seabattles.persistence.Battle;
import ru.redsoft.seabattles.persistence.BattleMember;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BattleMemberMapper {

    public BattleMemberResponse map(BattleMember battleMember) {
        return new BattleMemberResponse(
                battleMember.getId(),
                battleMember.getWarshipId(),
                battleMember.getBattleName(),
                battleMember.getResultForWarship()
        );
    }

    public BattleMember map(BattleMemberRequest request) {
        BattleMember member = new BattleMember();
        Battle battle = new Battle(request.getBattleName(), request.getBattleDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

        member.setBattleName(battle.getBattleName());
        member.setWarshipId(request.getWarshipId());
        member.setResultForWarship(request.getResultForWarship());

        return member;
    }

    public BattleMemberFindAllResponse map(BattleMember battleMember, WarshipResponse warship, BattleResponse battle) {
        return new BattleMemberFindAllResponse(
                battleMember.getId(),
                battle,
                warship,
                battleMember.getResultForWarship()
        );
    }

    public List<BattleMemberResponse> map(List<BattleMember> battleMembers) {
        return battleMembers.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

}
