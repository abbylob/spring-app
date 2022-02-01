package com.example.controller;

import com.example.dto.CountryDTO;
import com.example.dto.RegionDTO;
import com.example.entity.CountryEntity;
import com.example.entity.RegionEntity;
import com.example.response.GenericResponse;
import com.example.service.RegionService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "401", description = "Unauthorized") })
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    RegionService regionService;


    @GetMapping()
    ResponseEntity<GenericResponse> getAllRegions(){
        try {
            return new ResponseEntity<>(new GenericResponse(200,"success",regionService.getAllRegions()), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(new GenericResponse(200,"success",regionService.getAllRegions()), HttpStatus.ACCEPTED);

        }

    }
    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getRegion(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new GenericResponse(200,"success",regionService.getRegionById(id)), HttpStatus.ACCEPTED);
    }
    @PostMapping("")
    public ResponseEntity<GenericResponse> saveRegion(@RequestBody RegionDTO regionDTO){

        return new ResponseEntity<>(new GenericResponse(200,"success",regionService.saveRegion(regionDTO)), HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public  ResponseEntity<GenericResponse> updateRegion(@RequestBody RegionDTO regionDTO){
        return new ResponseEntity<>(new GenericResponse(200,"success",regionService.updateRegion(regionDTO)), HttpStatus.ACCEPTED);
    }
}
