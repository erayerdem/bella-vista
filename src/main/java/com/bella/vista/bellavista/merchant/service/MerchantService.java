package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MerchantService {

    Flux<MerchantDto> getMerchants();


    Mono<Merchant> saveMerchant(MerchantCreateRequestDto merchant, String merchantName);

    Flux <Coffee> getCoffees();

    void saveCoffee(List<Coffee> coffee, Merchant merchantId);

    Flux<Coffee> getCoffeesOfMerchant(Long merchantId);

    Mono<Merchant> findByName(String name);

    void deleteMerchantById(Long id);

    Flux<Merchant> fetchCoffeesOfMerchant(Long merchantId);
}
