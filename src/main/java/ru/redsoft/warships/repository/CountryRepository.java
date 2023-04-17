package ru.redsoft.warships.repository;

import ru.redsoft.warships.persistence.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> findAll();
}
