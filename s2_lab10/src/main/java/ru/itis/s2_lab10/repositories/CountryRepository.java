package ru.itis.s2_lab10.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.s2_lab10.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCode(String code);

}