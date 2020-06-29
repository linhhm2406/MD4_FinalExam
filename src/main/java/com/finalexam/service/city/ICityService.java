package com.finalexam.service.city;

import com.finalexam.model.City;
import com.finalexam.repository.city.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICityService {
    Iterable<City> findAll();
    Optional<City> findById(Long id);
    void saveCity(City city);
    void deleteCity(Long id);
}
