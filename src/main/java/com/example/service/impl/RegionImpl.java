package com.example.service.impl;

import com.example.dto.RegionDTO;
import com.example.entity.RegionEntity;
import com.example.repository.RegionRepository;
import com.example.service.RegionService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegionImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<RegionDTO>  getAllRegions(){
        List<RegionDTO> region = regionRepository.findAll().stream().map(s ->
                {
                    RegionDTO regionDTO = new RegionDTO();
                    regionDTO.setRegionId(s.getRegionId());
                    regionDTO.setRegionName(s.getRegionName());
                    return regionDTO;
                }
        ).collect(Collectors.toList());
        return region;
    }

    @Override
    public RegionDTO getRegionById(Integer id){
        RegionEntity region = regionRepository.findById(id).get();
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setRegionId(region.getRegionId());
        regionDTO.setRegionName(region.getRegionName());

        return regionDTO;
    }

    @Override
    public RegionDTO saveRegion(RegionDTO regionDTO){
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setRegionId(regionDTO.getRegionId());
        regionEntity.setRegionName(regionDTO.getRegionName());

        regionRepository.save(regionEntity);
        return regionDTO;
    }

    @Override
    public JSONObject updateRegion(RegionDTO regionDTO){
        RegionEntity regionEntity = regionRepository.getById(regionDTO.getRegionId());
        regionEntity.setRegionId(regionDTO.getRegionId());
        regionEntity.setRegionName(regionDTO.getRegionName());

        regionRepository.save(regionEntity);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
