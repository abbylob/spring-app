package com.example.service;

import com.example.dto.RegionDTO;
import com.example.entity.RegionEntity;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {
    List<RegionDTO> getAllRegions();

    RegionDTO getRegionById(Integer id);

    RegionDTO saveRegion(RegionDTO regionDTO);

    JSONObject updateRegion(RegionDTO regionDTO);
}
