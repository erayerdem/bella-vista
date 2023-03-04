package com.bella.vista.bellavista.water.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import com.bella.vista.bellavista.water.service.WaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("waters")
@RequiredArgsConstructor
public class WaterController {

    private  final WaterService waterService;
    @GetMapping
    public Flux<BaseResponse<Water>> getWaters(){
        return waterService.getWaters()
                .map(r -> BaseResponse.<Water>builder().data(r).build());
    }

    @PostMapping
    public BaseResponse<Mono<Water>> addWater(@RequestBody WaterRequestDto req){
            return BaseResponse.<Mono<Water>>builder().data(waterService.addWater(req)).build();
    }

    @DeleteMapping("{id}")
    public BaseResponse<Void> deleteWater(@PathVariable Long id) {
            waterService.deleteWater(id);
            return BaseResponse.success();
    }

    @GetMapping("{id}")
    public BaseResponse<Mono<Water>> getWater(@PathVariable Long id) {
        var water = waterService.getById(id);
        return BaseResponse.<Mono<Water>>builder().data(water).build();
    }
}
