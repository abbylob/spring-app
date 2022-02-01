package com.example.service.impl;

import com.example.dto.LocationDTO;
import com.example.entity.CountryEntity;
import com.example.entity.LocationEntity;
import com.example.repository.CountryRepository;
import com.example.repository.LocationRepository;
import com.example.service.LocationService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationsImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    CountryRepository countryRepository;

    @Override
    public JSONObject getAllLocations(){
        List<LocationDTO> location = locationRepository.findAll().stream().map(s ->
                {
                    LocationDTO locationDTO = new LocationDTO();
                    locationDTO.setLocationId(s.getLocationId());
                    locationDTO.setStreetAddress(s.getStreetAddress());
                    locationDTO.setPostalCode(s.getPostalCode());
                    locationDTO.setCity(s.getCity());
                    locationDTO.setCountryId(s.getCountryEntity().getCountryName());
                    return locationDTO;
                }
        ).collect(Collectors.toList());


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",location);
        return jsonObject;
    }

    @Override
    public JSONObject getLocationById(Integer id){
        List<LocationDTO> location = locationRepository.findById(id).stream().map(s ->
                {
                    LocationDTO locationDTO = new LocationDTO();
                    locationDTO.setLocationId(s.getLocationId());
                    locationDTO.setStreetAddress(s.getStreetAddress());
                    locationDTO.setPostalCode(s.getPostalCode());
                    locationDTO.setCity(s.getCity());
                    locationDTO.setCountryId(s.getCountryEntity().getCountryName());
                    return locationDTO;

                }
        ).collect(Collectors.toList());


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",location);
        return jsonObject;
    }

    @Override
    public JSONObject saveLocation(LocationDTO locationDTO){
        LocationEntity locationEntity = new LocationEntity();
        CountryEntity countryEntity = countryRepository.getById(locationDTO.getCountryId());
        locationEntity.setLocationId(locationDTO.getLocationId());
        locationEntity.setStreetAddress(locationDTO.getStreetAddress());
        locationEntity.setPostalCode(locationDTO.getPostalCode());
        locationEntity.setCity(locationDTO.getCity());
        locationEntity.setCountryEntity(countryEntity);

        locationRepository.save(locationEntity);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    @Override
    public JSONObject updateLocation(LocationDTO locationDTO){
        LocationEntity locationEntity = locationRepository.getById(locationDTO.getLocationId());//new LocationEntity();
        CountryEntity countryEntity = countryRepository.getById(locationDTO.getCountryId());
        locationEntity.setLocationId(locationDTO.getLocationId());
        locationEntity.setStreetAddress(locationDTO.getStreetAddress());
        locationEntity.setPostalCode(locationDTO.getPostalCode());
        locationEntity.setCity(locationDTO.getCity());
        locationEntity.setCountryEntity(countryEntity);

        locationRepository.save(locationEntity);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
