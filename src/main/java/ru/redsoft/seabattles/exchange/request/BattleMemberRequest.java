package ru.redsoft.seabattles.exchange.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.redsoft.seabattles.persistence.BattleResultForWarship;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleMemberRequest {

    private Long warshipId;

    private String battleName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate battleDate;

    private BattleResultForWarship resultForWarship;

}
