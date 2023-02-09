package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MerchantService {

    List<MerchantDto> getMerchants();


    Optional<Merchant> getByİd(Long id);

    Merchant saveMerchant(MerchantCreateRequestDto merchant, String merchantName);

    List <Coffee> getCoffees();

    Merchant getById(Long merchantId);

    void saveCoffee(List<Coffee> coffee, Merchant merchantId);

    Set<Coffee> getCoffeesOfMerchant(Long merchantId);

    Optional<Merchant> findByName(String name);

    void deleteMerchantById(Long id);
}
