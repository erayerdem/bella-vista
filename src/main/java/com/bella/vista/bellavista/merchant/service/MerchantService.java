package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.dto.Coffee;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    List<MerchantDto> getMerchants();

    Optional<Merchant> getMerchantByName(String name);

    void saveMerchant(MerchantCreateRequestDto merchant,String merchantName);

    List <Coffee> getCoffees();

    Optional<Merchant> getById(String merchantId);

    void saveCoffee(List<Coffee> coffee, Merchant merchantId);

    List<Coffee> getCoffeesOfMerchant(String merchantId);

    void deleteByMerchantAndCoffeeName(String merchantId, String coffeeName);

    Merchant getMerchant(String merchantId);
}
