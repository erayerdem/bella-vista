package com.bella.vista.bellavista.coffee.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

public interface CoffeeService {

    Flux<Coffee> getCoffees();

    void saveCoffee(Set<Coffee> coffee, Long merchantId);

    Mono<Merchant> getCoffeesOfMerchant(Long merchantId);

    void deleteById(Long id);

    Mono<Coffee> getById(Long id);
}
