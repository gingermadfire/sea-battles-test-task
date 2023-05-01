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
public class BattleMemberResponse {

    private Long id;

    private Long warshipId;

    private String battleName;

    private BattleResultForWarship resultForWarship;

}
