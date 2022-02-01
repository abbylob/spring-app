package com.example.service;

import com.example.dto.LocationDTO;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {
    JSONObject getAllLocations();

    JSONObject getLocationById(Integer id);

    JSONObject saveLocation(LocationDTO locationDTO);

    JSONObject updateLocation(LocationDTO locationDTO);
}
