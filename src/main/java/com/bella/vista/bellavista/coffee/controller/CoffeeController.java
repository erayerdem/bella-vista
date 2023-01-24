package com.bella.vista.bellavista.coffee.controller;


import com.bella.vista.bellavista.coffee.dto.Coffee;
import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.service.MerchantService;
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
import java.util.Optional;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
@Slf4j
public class CoffeeController {

    private final MerchantService merchantService;


    @GetMapping
    public BaseResponse<List<Coffee>> getCoffees(){
         return BaseResponse.<List<Coffee>>builder().data(merchantService.getCoffees()).build();
    }

    @PostMapping("merchants/{merchantId}")
    public BaseResponse<Void> setCoffee(@PathVariable String merchantId, @RequestBody List<Coffee> coffees)  {
        Optional<Merchant> byId = merchantService.getById(merchantId);
        if (byId.isPresent()) {
            Merchant merchant = byId.get();
            merchantService.saveCoffee(coffees,merchant);
            return BaseResponse.success();
        }
        throw new RuntimeException("Merchant Not Found");
    }

    @DeleteMapping("{coffeeId}")
    public BaseResponse<Void> deleteCoffee(@PathVariable String coffeeId){
        return BaseResponse.success();
    }
}
