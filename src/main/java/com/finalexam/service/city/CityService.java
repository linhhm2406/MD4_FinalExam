package com.finalexam.service.city;

import com.finalexam.model.City;
import com.finalexam.repository.city.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CityService implements ICityService{
    @Autowired
    ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public void saveCity(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        iCityRepository.deleteById(id);
    }
}
