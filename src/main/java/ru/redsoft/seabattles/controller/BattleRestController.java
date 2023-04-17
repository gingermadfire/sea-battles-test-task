package ru.redsoft.seabattles.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.redsoft.seabattles.exchange.request.BattleRequest;
import ru.redsoft.seabattles.exchange.response.BattleResponse;
import ru.redsoft.seabattles.service.BattleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/battles")
public class BattleRestController {

    private final BattleService battleService;

    @GetMapping
    public List<BattleResponse> findAll() {
        return battleService.findAll();
    }

    @PostMapping
    public BattleResponse save(@RequestBody BattleRequest request) {
        return battleService.save(request);
    }

}
