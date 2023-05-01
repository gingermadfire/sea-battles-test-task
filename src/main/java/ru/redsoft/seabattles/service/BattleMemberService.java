package ru.redsoft.seabattles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.seabattles.exception.BattleDateException;
import ru.redsoft.seabattles.exception.NotFoundException;
import ru.redsoft.seabattles.exchange.request.BattleMemberRequest;
import ru.redsoft.seabattles.exchange.request.BattleRequest;
import ru.redsoft.seabattles.exchange.response.BattleMemberFindAllResponse;
import ru.redsoft.seabattles.exchange.response.BattleMemberResponse;
import ru.redsoft.seabattles.exchange.response.BattleResponse;
import ru.redsoft.seabattles.exchange.response.WarshipResponse;
import ru.redsoft.seabattles.mapper.BattleMemberMapper;
import ru.redsoft.seabattles.persistence.BattleMember;
import ru.redsoft.seabattles.repository.implementation.BattleMembersRepositoryImpl;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BattleMemberService {

    private final BattleMemberMapper battleMembersMapper;

    private final BattleMembersRepositoryImpl battleMembersRepository;

    private final WarshipService warshipService;
    private final BattleService battleService;

    public List<BattleMemberFindAllResponse> findAll() {
        List<BattleMember> battleMembers = battleMembersRepository.findAll();
        List<BattleMemberFindAllResponse> findAllResponses = new ArrayList<>();

        for (BattleMember battleMember : battleMembers) {
            WarshipResponse warship = warshipService.findById(battleMember.getWarshipId());
            BattleResponse battle = battleService.findByName(battleMember.getBattleName());
            findAllResponses.add(battleMembersMapper.map(battleMember, warship, battle));
        }

        return findAllResponses;
    }

    public BattleMemberResponse save(BattleMemberRequest request) {
        WarshipResponse warship = warshipService.findById(request.getWarshipId());
        if (request.getBattleDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
                .compareTo(warship.getCommissionDate()) > 0) {
            battleService.save(new BattleRequest(
                    request.getBattleName(),
                    request.getBattleDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
            );

            return battleMembersMapper.map(
                    battleMembersRepository.save(
                            battleMembersMapper.map(request)
                    ).orElseThrow(() -> new NotFoundException("Battle member not saved"))
            );
        } else {
            throw new BattleDateException("Battle date earlier than warship commission date");
        }
    }

    public BattleMemberResponse update(BattleMemberRequest request) {
        WarshipResponse warship = warshipService.findById(request.getWarshipId());
        if (request.getBattleDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
                .compareTo(warship.getCommissionDate()) > 0) {
            battleService.save(new BattleRequest(
                    request.getBattleName(),
                    request.getBattleDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
            );

        return battleMembersMapper.map(
                battleMembersRepository.update(
                        battleMembersMapper.map(request)
                ).orElseThrow(() -> new NotFoundException("Battle member not saved"))
        );
        } else {
            throw new BattleDateException("Battle date earlier than warship commission date");
        }
    }

    public void delete(Long id) {
        battleMembersRepository.delete(id);
    }
}
