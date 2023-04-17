package ru.redsoft.seabattles.repository;

import ru.redsoft.seabattles.persistence.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> findAll();
}
