package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.mapper.MerchantMapper;
import com.bella.vista.bellavista.merchant.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService{

    private final MerchantRepository merchantRepository;

    private final MerchantMapper mapper;
    @Override
    public List<MerchantDto> getMerchants() {
        var merchants = merchantRepository.findAll();
        return  StreamSupport
                .stream(merchants.spliterator(), false)
                .map(mapper::toDto).collect(Collectors.toList());
    }


    @Override
    public Optional<Merchant> getByİd(Long id) {
        return merchantRepository.findById(id);
    }


    @Override
    public Merchant saveMerchant(MerchantCreateRequestDto merchant,String merchantName) {
        return merchantRepository.save(
                Merchant.builder()
                        .name(merchantName)
                        .city(merchant.city())
                        .about(merchant.about())
                        .build());
    }

    @Override
    public List<Coffee> getCoffees() {
      return  StreamSupport
                .stream(merchantRepository.findAll().spliterator(), false)
                .map(Merchant::getCoffees)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream).toList();
    }
    @Override
    public Merchant getById(Long merchantId) {
        return merchantRepository.findById(merchantId).orElseThrow(() -> new RuntimeException("Merchant Not Found"));
    }


    @Override
    public void saveCoffee(List<Coffee> coffee, Merchant merchant) {
        coffee.forEach(e-> merchant.getCoffees().add(e));
        merchantRepository.save(merchant);
    }


    @Override
    public Set<Coffee> getCoffeesOfMerchant(Long merchantId) {
        return getById(merchantId).getCoffees();

    }

    @Override
    public Optional<Merchant> findByName(String name) {
        return merchantRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteMerchantById(Long id) {
        var merchant = getById(id);
        merchantRepository.delete(merchant);
    }

    @Override
    public Merchant fetchCoffeesOfMerchant(Long merchantId) {
        return merchantRepository.findByIdFetchCoffees(merchantId).orElseThrow(() -> new RuntimeException("Merchant Not Found"));
    }

}
