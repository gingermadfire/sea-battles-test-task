package ru.redsoft.seabattles.mapper;

import org.springframework.stereotype.Component;
import ru.redsoft.seabattles.exchange.response.WarshipResponse;
import ru.redsoft.seabattles.persistence.Warship;

import java.util.List;
import java.util.stream.Collectors;

@Component
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
