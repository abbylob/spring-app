package com.example.controller;

import com.example.dto.LocationDTO;
import com.example.dto.RegionDTO;
import com.example.response.GenericResponse;
import com.example.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping()
    ResponseEntity<GenericResponse> getAllLocations(){
        try {
            return new ResponseEntity<>(new GenericResponse(200,"success",locationService.getAllLocations()), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(new GenericResponse(200,"success",locationService.getAllLocations()), HttpStatus.ACCEPTED);

        }

    }
    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getLocations(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new GenericResponse(200,"success",locationService.getLocationById(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> saveLocation(@RequestBody LocationDTO locationDTO){

        return new ResponseEntity<>(new GenericResponse(200,"success",locationService.saveLocation(locationDTO)), HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public  ResponseEntity<GenericResponse> updateLocation(@RequestBody LocationDTO locationDTO){
        return new ResponseEntity<>(new GenericResponse(200,"success",locationService.updateLocation(locationDTO)), HttpStatus.ACCEPTED);
    }
}
