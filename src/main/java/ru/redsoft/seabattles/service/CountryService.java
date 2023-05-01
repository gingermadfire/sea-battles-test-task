package ru.redsoft.seabattles.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.seabattles.exchange.response.CountryResponse;
import ru.redsoft.seabattles.mapper.CountryMapper;
import ru.redsoft.seabattles.repository.implementation.CountryRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepositoryImpl countryRepository;

    public List<CountryResponse> findAll() {
        return countryMapper.map(countryRepository.findAll());
    }

}
