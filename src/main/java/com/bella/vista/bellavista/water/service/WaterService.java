package com.bella.vista.bellavista.water.service;

import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WaterService {

    Flux<Water> getWaters();
     Mono<Water> addWater(WaterRequestDto req);
     void deleteWater(Long id);

    Mono<Water> getById(Long id);
}
