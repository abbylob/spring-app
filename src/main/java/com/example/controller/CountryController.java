package com.example.controller;

import com.example.dto.CountryDTO;
import com.example.entity.CountryEntity;
import com.example.response.GenericResponse;
import com.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping()
    public ResponseEntity<GenericResponse> getAllCountries(){
        try {
            return new ResponseEntity<>(new GenericResponse(200,"success",countryService.getAllCountries()), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(new GenericResponse(200,"success",countryService.getAllCountries()), HttpStatus.ACCEPTED);

        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getCountry(@PathVariable("id") String id){
        return new ResponseEntity<>(new GenericResponse(200,"success",countryService.getCountryById(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> saveCountry(@RequestBody CountryDTO countryDTO){

        return new ResponseEntity<>(new GenericResponse(200,"success",countryService.saveCountry(countryDTO)), HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public  ResponseEntity<GenericResponse> updateCountry(@RequestBody CountryDTO countryDTO){
        return new ResponseEntity<>(new GenericResponse(200,"success",countryService.updateCountry(countryDTO)), HttpStatus.ACCEPTED);
    }
}
