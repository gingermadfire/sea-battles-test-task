package ru.redsoft.warships.mapper;

import ru.redsoft.warships.exchange.response.WarshipResponse;
import ru.redsoft.warships.persistence.Warship;

import java.util.List;
import java.util.stream.Collectors;

public class WarshipMapper {

    public WarshipResponse map(Warship warship) {
        return new WarshipResponse(
                warship.getName(),
                warship.getWarshipClass(),
                warship.getCommissionDate(),
                warship.getDecommissionDate()
        );
    }

    public List<WarshipResponse> map(List<Warship> warships) {
        return warships.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
