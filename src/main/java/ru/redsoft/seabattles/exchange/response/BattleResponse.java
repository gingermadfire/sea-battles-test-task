package ru.redsoft.seabattles.exchange.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BattleResponse {

    private String battleName;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Instant battleDate;

}
