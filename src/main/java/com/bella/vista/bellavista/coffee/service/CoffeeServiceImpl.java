package com.bella.vista.bellavista.coffee.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.coffee.repository.CoffeeRepository;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepository repo;

    private final MerchantService merchantService;
    @Override
    public List<Coffee> getCoffees() {
      return repo.findAll();
    }

    @Override
    @Transactional
    public void saveCoffee(Set<Coffee> coffee, Long merchantId) {
        Merchant merchant = merchantService.getById(merchantId);
        merchant.putCoffee(coffee);
    }


    @Override
    @Transactional
    public Set<Coffee> getCoffeesOfMerchant(Long merchantId) {
        Merchant merchant = merchantService.getById(merchantId);
        return merchant.getCoffees();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
