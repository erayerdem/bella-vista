package com.bella.vista.bellavista.coffee.controller;


import com.bella.vista.bellavista.coffee.dto.CoffeeDto;
import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.coffee.mapper.CoffeeMapper;
import com.bella.vista.bellavista.coffee.service.CoffeeService;
import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
@Slf4j
public class CoffeeController {

    private final CoffeeService coffeeService;

    private final CoffeeMapper coffeeMapper;

    @GetMapping
    public BaseResponse<List<Coffee>> getCoffees(){
         return BaseResponse.<List<Coffee>>builder().data(coffeeService.getCoffees()).build();
    }

    @GetMapping("/merchants/{merchantId}")
    public BaseResponse<Merchant> getCoffeesOfMerchant(@NotBlank @PathVariable Long merchantId){
        return BaseResponse.<Merchant>builder().data(coffeeService.getCoffeesOfMerchant(merchantId)).build();
    }

    @PostMapping("/merchants/{merchantId}")
    public BaseResponse<Void> setCoffee(@NotBlank @PathVariable Long merchantId, @NotEmpty @RequestBody List<CoffeeDto> coffees)  {
        Set<Coffee> collect = coffees.stream().map(coffeeMapper::toEntity).collect(Collectors.toSet());
        coffeeService.saveCoffee(collect,merchantId);
        return BaseResponse.success();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteCoffee(@NotBlank @PathVariable Long id ){
        coffeeService.deleteById(id);
        return BaseResponse.success();
    }


}
