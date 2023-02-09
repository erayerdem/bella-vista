package com.bella.vista.bellavista.coffee.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;

import java.util.List;
import java.util.Set;

public interface CoffeeService {

    List<Coffee> getCoffees();


    void saveCoffee(Set<Coffee> coffee, Long merchantId);

    Set<Coffee> getCoffeesOfMerchant(Long merchantId);

    void deleteById(Long id);
}
