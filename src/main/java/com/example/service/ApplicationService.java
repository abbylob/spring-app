package com.example.service;

import com.example.dto.BeeceptorDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ApplicationService {

    String firstService();
    BeeceptorDTO testHttp() throws IOException ;
    void testPostHttp(BeeceptorDTO beeceptorDTO) throws IOException;
    void testMyFirstObject(BeeceptorDTO beeceptorDTO);
}