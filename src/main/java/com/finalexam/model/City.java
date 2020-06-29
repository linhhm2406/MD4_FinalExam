package com.finalexam.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String cityName;

    @NotNull
    @Positive(message = "Nhập vào số dương")
    private double area;

    @NotNull
    @Positive(message = "Nhập vào số dương")
    private Long population;

    @NotNull
    @Positive(message = "Nhập vào số dương")
    private double gdp;

    @NotEmpty
    @Size(min = 10)
    private String des;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(Long id, @NotEmpty @Size(max = 50) String cityName, @NotNull @Positive(message = "Nhập vào số dương") Double area, @NotNull @Positive(message = "Nhập vào số dương") Long population, @NotNull @Positive(message = "Nhập vào số dương") Double gdp, @NotEmpty @Size(min = 10) String des, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.des = des;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
