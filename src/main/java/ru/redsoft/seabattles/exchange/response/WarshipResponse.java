package ru.redsoft.seabattles.exchange.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.redsoft.seabattles.persistence.WarshipClass;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarshipResponse {

    private String name;

    private WarshipClass warshipClass;

    private Instant commissionDate;

    private Instant decommissionDate;

}
