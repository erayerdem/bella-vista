package com.bella.vista.bellavista.coffee.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.coffee.repository.CoffeeRepository;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepository repo;

    private final MerchantService merchantService;
    @Override
    public Flux<Coffee> getCoffees() {
      return repo.findAll();
    }

    @Override
    @Transactional
    public void saveCoffee(Set<Coffee> coffee, Long merchantId) {
         merchantService.getById(merchantId)
                         .subscribe(merchant -> merchant.putCoffee(coffee));
    }


    @Override
    public Mono<Merchant> getCoffeesOfMerchant(Long merchantId) {
        return merchantService.fetchCoffeesOfMerchant(merchantId);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id).subscribe();
    }

    @Override
    public Mono<Coffee> getById(Long id) {
        return repo.findById(id).switchIfEmpty(Mono.error(new RuntimeException("Coffee Not Found")));
    }

}
