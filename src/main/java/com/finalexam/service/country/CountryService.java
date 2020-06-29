package com.finalexam.service.country;

import com.finalexam.model.Country;
import com.finalexam.repository.country.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CountryService implements ICountryService {

    @Autowired
    ICountryRepository iCountryRepository;

    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return iCountryRepository.findById(id);
    }
}
