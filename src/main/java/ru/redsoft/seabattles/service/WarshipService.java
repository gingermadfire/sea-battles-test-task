package ru.redsoft.seabattles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.seabattles.exception.NotFoundException;
import ru.redsoft.seabattles.exchange.response.WarshipResponse;
import ru.redsoft.seabattles.mapper.WarshipMapper;
import ru.redsoft.seabattles.repository.WarshipRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarshipService {

    private final WarshipMapper warshipMapper;
    private final WarshipRepository warshipRepository;

    public WarshipResponse findById(Long id) {
        return warshipRepository.findById(id)
                .map(warshipMapper::map)
                .orElseThrow(() -> new NotFoundException(String.format("Warship with ID = %d not found", id)));
    }

    public List<WarshipResponse> findAll() {
        return warshipMapper.map(warshipRepository.findAll());
    }
}
