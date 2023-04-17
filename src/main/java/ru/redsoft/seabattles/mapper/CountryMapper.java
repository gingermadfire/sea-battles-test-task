package ru.redsoft.seabattles.mapper;

import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.exchange.response.CountryResponse;
import ru.redsoft.seabattles.persistence.Country;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    private CountryResponse map(Country country) {
        return new CountryResponse(
                country.getName(),
                country.getSide()
        );
    }

    public List<CountryResponse> map(List<Country> countries) {
        return countries.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

}
