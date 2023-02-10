package com.bella.vista.bellavista.water.service;

import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import com.bella.vista.bellavista.water.repository.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WaterServiceImpl implements WaterService {


    private final WaterRepository waterRepository;
    @Override
    public List<Water> getWaters() {
        return waterRepository.findAll();
    }

    @Override
    public Water addWater(WaterRequestDto req) {
        var water = Water.builder().name(req.name()).build();
        return waterRepository.save(water);
    }

    @Override
    public void deleteWater(Long id) {
        Water entity = this.getById(id);
        waterRepository.delete(entity);
    }

    @Override
    public Water getById(Long id) {
        return waterRepository.findById(id).orElseThrow(() -> new RuntimeException("Water Not Found"));
    }
}
