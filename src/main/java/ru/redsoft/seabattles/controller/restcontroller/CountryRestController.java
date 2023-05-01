package ru.redsoft.seabattles.controller.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsoft.seabattles.exchange.response.CountryResponse;
import ru.redsoft.seabattles.service.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping
    public List<CountryResponse> findAll() {
        return countryService.findAll();
    }

}






