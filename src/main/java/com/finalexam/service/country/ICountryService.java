package com.finalexam.service.country;

import com.finalexam.model.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICountryService {
    Iterable<Country> findAll();
    Optional<Country> findById(Long id);
}
