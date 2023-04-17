package ru.redsoft.seabattles.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsoft.seabattles.exchange.response.WarshipResponse;
import ru.redsoft.seabattles.service.WarshipService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/warships")
public class WarshipRestController {

    private final WarshipService warshipService;

    @GetMapping("/{id}")
    public WarshipResponse findById(@PathVariable Long id) {
        return warshipService.findById(id);
    }

    @GetMapping
    public List<WarshipResponse> findAll() {
        return warshipService.findAll();
    }
}
