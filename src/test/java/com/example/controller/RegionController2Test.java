package com.example.controller;

import com.example.dto.RegionDTO;
import com.example.service.RegionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Proporciona la funcionalidad para iniciar Spring TestContext
@ExtendWith(SpringExtension.class)
//Se usa para pruebas unitarias de spring mvc
// y solo para inicializar RegionController, los demás componentes y asignaciones no se iniciarán.
@WebMvcTest(value = RegionController.class)
public class RegionController2Test {

    //Soporte de prueba de spring mvc de lado del servidor, permite ejecutar solicitudes contra
    // el contexto de prueba.
    @Autowired
    private MockMvc mockMvc;

    //Mockbean se usa para agregar simulaciones a Spring ApplicationContext,
    // se crea una simulacion de RegionService y se conecta automaticamente a RegionController.
    @MockBean
    private RegionService regionService;

    //Se declara objeto preespecificado para evitar la consulta a la base de datos.
    RegionDTO RECORD_1 = new RegionDTO(1,"Region1");
    RegionDTO RECORD_2 = new RegionDTO(2,"Region2");

    @Test
    void getAllRegions() throws Exception{
        //Simula el metodo getAllRegions y devuelve las regiones especificadas
        Mockito.when(regionService.getAllRegions()).thenReturn(Arrays.asList(RECORD_1,RECORD_2));

        // Generador de peticiones para ejecutar una solicitud get
        //en el que se le pasa un header application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/region").accept(
                MediaType.APPLICATION_JSON);
        // mockMvc realiza la solicitud y devuelve la respuesta simulada
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //Se imprime respuesta
        System.out.println(result.getResponse());
        //Se declara el resultado esperado
        String expected = "{'code':200,'message':'success','data':[{'regionId':1,'regionName':'Region1'},{'regionId':2,'regionName':'Region2'}]}";

        //JsonAssert permite hacer afirmaciones contra una cadeja json
        //strict true para verificar todos los campos de la respuesta
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(),true);

        Assertions.assertEquals(HttpStatus.ACCEPTED.value(),result.getResponse().getStatus());
        Assertions.assertNotNull(result.getResponse(),"response is null");

    }

    @Test
    void getRegion() throws Exception{
        //Simula el metodo getRegionById y devuelve la region especificada
        Mockito.when(regionService.getRegionById(RECORD_2.getRegionId())).thenReturn(RECORD_2);

        // Generador de peticiones para ejecutar una solicitud get
        //en el que se le pasa un header application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/region/2").accept(
                MediaType.APPLICATION_JSON);
        // mockMvc realiza la solicitud y devuelve la respuesta simulada
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //Se imprime respuesta
        System.out.println(result.getResponse());

        //Se declara el resultado esperado
        String expected = "{'code':200,'message':'success','data':{'regionId':2,'regionName':'Region2'}}";

        //JsonAssert permite hacer afirmaciones contra una cadeja json
        //strict true para verificar todos los campos de la respuesta
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(),true);

        Assertions.assertEquals(HttpStatus.ACCEPTED.value(),result.getResponse().getStatus());
        Assertions.assertNotNull(result.getResponse(),"response is null");
    }
    
    @Test
    void saveRegion() throws Exception {
        RegionDTO RECORD_3 = new RegionDTO(9,"Region3");
        Mockito.when(regionService.saveRegion(RECORD_3)).thenReturn(RECORD_3);

        //La clase se serializa a json
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(RECORD_3);
        System.out.println(jsonContent);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/region")
                .accept(MediaType.APPLICATION_JSON).content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertEquals(HttpStatus.ACCEPTED.value(), result.getResponse().getStatus());


    }
}

