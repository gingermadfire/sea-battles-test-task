package ru.redsoft.warships.mapper;

import org.springframework.stereotype.Component;
import ru.redsoft.warships.exchange.response.CountryResponse;
import ru.redsoft.warships.persistence.Country;

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
