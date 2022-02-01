package com.example.service;

import com.example.dto.CountryDTO;
import com.example.entity.CountryEntity;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {
    JSONObject getAllCountries();

    JSONObject getCountryById(String id);

    JSONObject saveCountry(CountryDTO CountryDTO);

    JSONObject updateCountry(CountryDTO countryDTO);
}
