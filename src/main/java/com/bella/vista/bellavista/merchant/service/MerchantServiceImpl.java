package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.coffee.dto.Coffee;
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
    public Optional<Merchant> getMerchantByName(String name) {
        return merchantRepository.getByNameKeyword(name);
    }

    @Override
    public void saveMerchant(MerchantCreateRequestDto merchant,String merchantName) {
        merchantRepository.save(
                Merchant.builder()
                        .name(merchantName)
                        .city(merchant.city())
                        .about(merchant.about())
                        .createdDate(OffsetDateTime.now())
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
    public Optional<Merchant> getById(String merchantId) {
        return merchantRepository.findById(merchantId);
    }

    @Override
    public void saveCoffee(List<Coffee> coffee, Merchant merchant) {
        coffee.forEach(e-> merchant.getCoffees().add(e));
        merchantRepository.save(merchant);
    }
}
