package ru.redsoft.warships.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsoft.warships.exchange.response.CountryResponse;
import ru.redsoft.warships.mapper.CountryMapper;
import ru.redsoft.warships.repository.CountryRepositoryImpl;

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
