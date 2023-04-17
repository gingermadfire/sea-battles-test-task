package ru.redsoft.seabattles.mapper;

import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.exchange.request.BattleRequest;
import ru.redsoft.seabattles.exchange.response.BattleResponse;
import ru.redsoft.seabattles.persistence.Battle;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BattleMapper {

    public BattleResponse map(Battle battle) {
        return new BattleResponse(
                battle.getBattleName(),
                battle.getBattleDate()
        );
    }

    public List<BattleResponse> map(List<Battle> battles) {
        return battles.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Battle map(BattleRequest request) {
        return new Battle(
                request.getBattleName(),
                request.getBattleDate()
        );
    }

}
