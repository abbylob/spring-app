package com.example.controller;

import com.example.dto.RegionDTO;
import com.example.entity.RegionEntity;
import com.example.repository.RegionRepository;
import com.example.service.RegionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegionController.class)
class RegionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    RegionService regionService;

    @MockBean
    RegionRepository regionRepository;

    //Se declara objeto preespecificado para evitar la consulta a la base de datos.
    RegionDTO RECORD_1 = new RegionDTO(1,"Region1");
    RegionDTO RECORD_2 = new RegionDTO(2,"Region2");
    RegionDTO RECORD_3 = new RegionDTO(9,"Region3");


    @Test
    void getAllRegions() throws Exception{

        List<RegionDTO> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
        //Burla el getAllRegions(), cada vez que se llama al método dentro del controlador,
        //devolverá el valor especificado
        Mockito.when(regionService.getAllRegions()).thenReturn(records);

        //Llamada a la api
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/region")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    void getRegion() throws Exception{

        Mockito.when(regionService.getRegionById(RECORD_1.getRegionId())).thenReturn(RECORD_1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/region/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    void saveRegion() throws Exception {
        RegionDTO record = new RegionDTO(6,"testInsert");

        Mockito.when(regionService.saveRegion(record)).thenReturn(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/region")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    void updateRegion() throws Exception {
        RegionDTO record = new RegionDTO(6,"testInsert");

        Mockito.when(regionService.updateRegion(record)).thenReturn(new JSONObject());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/region")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", notNullValue()));
    }

}