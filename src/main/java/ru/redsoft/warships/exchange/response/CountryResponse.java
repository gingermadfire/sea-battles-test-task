package ru.redsoft.warships.exchange.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.redsoft.warships.persistence.Side;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {

    private String name;

    private Side side;

}
