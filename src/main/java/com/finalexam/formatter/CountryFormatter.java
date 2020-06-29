package com.finalexam.formatter;

import com.finalexam.model.Country;
import com.finalexam.service.country.CountryService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CountryFormatter implements Formatter<Country> {
    private CountryService countryService;

    public CountryFormatter(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        Optional<Country> countryOptional = countryService.findById(Long.parseLong(text));
        Country country = countryOptional.get();
        return country;
    }

    @Override
    public String print(Country object, Locale locale) {
        return null;
    }
}
