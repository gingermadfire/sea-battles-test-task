package ru.redsoft.warships.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsoft.warships.exchange.response.WarshipResponse;
import ru.redsoft.warships.service.WarshipService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warships")
@RequiredArgsConstructor
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
