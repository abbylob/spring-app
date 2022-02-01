package com.example.service.impl;

import com.example.dto.CountryDTO;
import com.example.entity.CountryEntity;
import com.example.entity.RegionEntity;
import com.example.repository.CountryRepository;
import com.example.repository.RegionRepository;
import com.example.service.CountryService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    RegionRepository regionRepository;

    @Override
    public JSONObject getAllCountries(){
        List<CountryDTO> country = countryRepository.findAll().stream().map(s ->
                {
                    CountryDTO countryDTO = new CountryDTO();
                    countryDTO.setCountryId(s.getCountryId());
                    countryDTO.setCountryName(s.getCountryName());
                    countryDTO.setRegionId(s.getRegionEntity().getRegionId());
                    return countryDTO;
                }
        ).collect(Collectors.toList());


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",country);
        return jsonObject;
    }

    @Override
    public JSONObject getCountryById(String id){
        List<CountryDTO> country = countryRepository.findById(id).stream().map(s ->
                {
                    CountryDTO countryDTO = new CountryDTO();
                    countryDTO.setCountryId(s.getCountryId());
                    countryDTO.setCountryName(s.getCountryName());
                    countryDTO.setRegionId(s.getRegionEntity().getRegionId());
                    return countryDTO;
                }
        ).collect(Collectors.toList());


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",country);
        return jsonObject;
    }

    @Override
    public JSONObject saveCountry(CountryDTO countryDTO){
        CountryEntity countryEntity = new CountryEntity();
        RegionEntity regionEntity = regionRepository.getById(countryDTO.getRegionId());
        countryEntity.setCountryId(countryDTO.getCountryId());
        countryEntity.setCountryName(countryDTO.getCountryName());
        countryEntity.setRegionEntity(regionEntity);

        countryRepository.save(countryEntity);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    @Override
    public JSONObject updateCountry(CountryDTO countryDTO){

        CountryEntity countryEntity = countryRepository.getById(countryDTO.getCountryId());
        RegionEntity regionEntity = regionRepository.getById(countryDTO.getRegionId());
        countryEntity.setCountryId(countryDTO.getCountryId());
        countryEntity.setCountryName(countryDTO.getCountryName());
        countryEntity.setRegionEntity(regionEntity);

        countryRepository.save(countryEntity);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;

    }
}
