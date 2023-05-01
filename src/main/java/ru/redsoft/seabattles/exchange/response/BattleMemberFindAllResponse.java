package ru.redsoft.seabattles.exchange.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.redsoft.seabattles.persistence.BattleResultForWarship;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleMemberFindAllResponse {

    private Long id;

    private BattleResponse battle;

    private WarshipResponse warship;

    private BattleResultForWarship resultForWarship;

}
