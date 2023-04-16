package ru.redsoft.warships.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.warships.exchange.response.WarshipResponse;
import ru.redsoft.warships.mapper.WarshipMapper;
import ru.redsoft.warships.repository.WarshipRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarshipService {

    private final WarshipMapper warshipMapper;
    private final WarshipRepository warshipRepository;

    public List<WarshipResponse> findAll() {
        return warshipMapper.map(warshipRepository.findAll());
    }
}
