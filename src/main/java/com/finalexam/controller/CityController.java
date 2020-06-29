package com.finalexam.controller;

import com.finalexam.model.City;
import com.finalexam.model.Country;
import com.finalexam.service.city.ICityService;
import com.finalexam.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    public ICountryService countryService;

    @Autowired
    public ICityService cityService;

    @ModelAttribute("countryList")
    public Iterable<Country> countryList(){
        List<Country> countryList = (List<Country>) countryService.findAll();
        return countryList;
    }

    @GetMapping("/")
    public ModelAndView show(){
        List<City> cityList = (List<City>) cityService.findAll();
        return new ModelAndView("city/showListCity","cityList", cityList);
    }

    @GetMapping("/addNewCity")
    public ModelAndView showAddForm(){
        return new ModelAndView("city/createNewCity","city", new City());
    }

    @PostMapping("/addNewCity")
    public ModelAndView addNewCity(@ModelAttribute("city") City city){
        List<City> cityList = (List<City>) cityService.findAll();
        city.setId(Long.parseLong(String.valueOf(cityList.size()+1)));
        cityService.saveCity(city);
        ModelAndView modelAndView = new ModelAndView("city/showListCity");
        cityList =  (List<City>) cityService.findAll();
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("add", "Thêm thành công");
        return modelAndView;
    }

    @GetMapping("/showDetail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        City cityToShow = city.get();
        return new ModelAndView("city/showDetail","city",cityToShow);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        City cityToShow = city.get();
        return new ModelAndView("city/editCity","city",cityToShow);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, @ModelAttribute City city){
        cityService.saveCity(city);
        ModelAndView modelAndView = new ModelAndView("city/showListCity");
        List<City> cityList = (List<City>) cityService.findAll();
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("edit", "Sửa thành công");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        City cityToShow = city.get();
        return new ModelAndView("city/showDelete","city",cityToShow);
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        cityService.deleteCity(id);
        ModelAndView modelAndView =  new ModelAndView("city/showListCity");
        List<City> cityList = (List<City>) cityService.findAll();
        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }
}
