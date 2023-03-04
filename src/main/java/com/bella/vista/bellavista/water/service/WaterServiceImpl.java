package com.bella.vista.bellavista.water.service;

import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import com.bella.vista.bellavista.water.repository.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class WaterServiceImpl implements WaterService {


    private final WaterRepository waterRepository;
    @Override
    public Flux<Water> getWaters() {
        return waterRepository.findAll();
    }

    @Override
    public Mono<Water> addWater(WaterRequestDto req) {
        var water = Water.builder().name(req.name()).build();
        return waterRepository.save(water);
    }

    @Override
    public void deleteWater(Long id) {
        Mono<Water> entity = this.getById(id);
        waterRepository.delete(Objects.requireNonNull(entity.block()));
    }

    @Override
    public Mono<Water> getById(Long id) {
        return waterRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Water Not Found")));
    }
}
