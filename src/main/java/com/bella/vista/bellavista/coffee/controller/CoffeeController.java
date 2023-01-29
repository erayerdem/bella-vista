package com.bella.vista.bellavista.coffee.controller;


import com.bella.vista.bellavista.coffee.dto.Coffee;
import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.service.MerchantService;
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

    @GetMapping("merchants/{merchantId}")
    public BaseResponse<List<Coffee>> getCoffeesOfMerchant(@NotBlank @PathVariable String merchantId){
        return BaseResponse.<List<Coffee>>builder().data(merchantService.getCoffeesOfMerchant(merchantId)).build();
    }

    @PostMapping("merchants/{merchantId}")
    public BaseResponse<Void> setCoffee(@NotBlank @PathVariable String merchantId, @NotEmpty @RequestBody List<Coffee> coffees)  {
        Merchant merchant = merchantService.getMerchant(merchantId);
        merchantService.saveCoffee(coffees,merchant);
        return BaseResponse.success();
    }

    @DeleteMapping("{coffeeName}/merchants/{merchantId}")
    public BaseResponse<Void> deleteCoffee(@NotBlank @PathVariable String merchantId ,@NotBlank  @PathVariable String coffeeName){
        merchantService.deleteByMerchantAndCoffeeName(merchantId,coffeeName);
        return BaseResponse.success();
    }


}
