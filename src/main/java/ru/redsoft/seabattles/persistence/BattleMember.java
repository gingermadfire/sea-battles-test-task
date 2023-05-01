package ru.redsoft.seabattles.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleMember {

    private Long id;

    private Long warshipId;

    private String battleName;

    private BattleResultForWarship resultForWarship;

}
