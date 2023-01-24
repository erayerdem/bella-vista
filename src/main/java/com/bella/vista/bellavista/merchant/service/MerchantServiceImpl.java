package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.mapper.MerchantMapper;
import com.bella.vista.bellavista.merchant.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
public class MerchantServiceImpl implements MerchantService{

    private final MerchantRepository merchantRepository;

    private final MerchantMapper mapper;
    @Override
    public List<MerchantDto> getMerchants() {
        var merchants = merchantRepository.findAll();
        return  StreamSupport
                .stream(merchants.spliterator(), true)
                .map(mapper::toDto).collect(Collectors.toList());
    }
}
