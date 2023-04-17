package ru.redsoft.seabattles.exchange.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleRequest {

    private String battleName;

    private Instant battleDate;

}
