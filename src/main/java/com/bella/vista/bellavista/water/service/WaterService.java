package com.bella.vista.bellavista.water.service;

import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface WaterService {

    List<Water> getWaters();
     Water addWater(WaterRequestDto req);
     void deleteWater(Long id);

    Water getById(Long id);
}
