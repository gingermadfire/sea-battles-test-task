package ru.redsoft.seabattles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.seabattles.exception.NotFoundException;
import ru.redsoft.seabattles.exchange.request.BattleRequest;
import ru.redsoft.seabattles.exchange.response.BattleResponse;
import ru.redsoft.seabattles.mapper.BattleMapper;
import ru.redsoft.seabattles.repository.BattleRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BattleService {

    private final BattleMapper battleMapper;
    private final BattleRepositoryImpl battleRepository;

    public List<BattleResponse> findAll() {
        return battleMapper.map(battleRepository.findAll());
    }

    public BattleResponse save(BattleRequest request) {
        return battleMapper.map(battleRepository.save(battleMapper.map(request))
                        .orElseThrow(() -> new NotFoundException("Battle not saved")));
    }

}
