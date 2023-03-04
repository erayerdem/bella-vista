package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.coffee.repository.CoffeeRepository;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.mapper.MerchantMapper;
import com.bella.vista.bellavista.merchant.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService{

    private final MerchantRepository merchantRepository;

    private final CoffeeRepository coffeeRepository;

    private final MerchantMapper mapper;
    @Override
    public Flux<MerchantDto> getMerchants() {
          return merchantRepository.findAll()
                  .map(mapper::toDto);
    }


    @Override
    public Mono<Merchant> saveMerchant(MerchantCreateRequestDto merchant,String merchantName) {
        return merchantRepository.save(
                Merchant.builder()
                        .name(merchantName)
                        .city(merchant.city())
                        .about(merchant.about())
                        .build());
    }

    @Override
    public Flux<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }
    @Override
    public Mono<Merchant> getById(Long merchantId) {
        return merchantRepository.findById(merchantId).switchIfEmpty(Mono.error(new RuntimeException("Merchant Not Found")));
    }


    @Override
    public void saveCoffee(List<Coffee> coffee, Merchant merchant) {
        coffee.forEach(e-> merchant.getCoffees().add(e));
        merchantRepository.save(merchant);
    }


    @Override
    public Flux<Coffee> getCoffeesOfMerchant(Long merchantId) {
         getById(merchantId)
                .map(e->Flux.just(e.getCoffees()));



    }

    @Override
    public Mono<Merchant> findByName(String name) {
        return merchantRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteMerchantById(Long id) {
        var merchant = getById(id);
        merchantRepository.delete(merchant);
    }

    @Override
    public Flux<Merchant> fetchCoffeesOfMerchant(Long merchantId) {
        return merchantRepository.findByIdFetchCoffees(merchantId).switchIfEmpty(Mono.error(new RuntimeException("Ana sikem")));
    }

}
