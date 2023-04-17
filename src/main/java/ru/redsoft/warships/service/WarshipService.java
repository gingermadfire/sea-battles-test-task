package ru.redsoft.warships.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.warships.exception.NotFoundException;
import ru.redsoft.warships.exchange.response.WarshipResponse;
import ru.redsoft.warships.mapper.WarshipMapper;
import ru.redsoft.warships.repository.WarshipRepository;

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
