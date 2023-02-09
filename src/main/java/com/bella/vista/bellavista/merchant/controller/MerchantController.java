package com.bella.vista.bellavista.merchant.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.mapper.MerchantMapper;
import com.bella.vista.bellavista.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("merchants")
@RequiredArgsConstructor
@Slf4j
public class MerchantController {
    private final MerchantMapper merchantMapper;

    private final MerchantService merchantService;

    @GetMapping
    public BaseResponse<List<MerchantDto>> getMerchants(){
        List<MerchantDto> merchants = merchantService.getMerchants();
        return BaseResponse.<List<MerchantDto>>builder().data(merchants).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<MerchantDto> insertMerchant(@RequestBody MerchantCreateRequestDto req ){
        String capitalize = WordUtils.capitalize(StringUtils.normalizeSpace(req.merchantName()));
        Optional<Merchant> merchantByName = merchantService.findByName(capitalize);
        if (merchantByName.isEmpty()) {
            var merchant = merchantService.saveMerchant(req, capitalize);
            return BaseResponse.<MerchantDto>builder().data(merchantMapper.toDto(merchant)).build();
        }
        throw new RuntimeException("Merchant Already Exist");
    }

    @GetMapping("/{id}")
    public BaseResponse<MerchantDto> getMerchant(@PathVariable Long id){
        var  merchant = merchantMapper.toDto(merchantService.getById(id));
        return BaseResponse.<MerchantDto>builder().data(merchant).build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteMerchant(@PathVariable Long id){
        merchantService.deleteMerchantById(id);
        return BaseResponse.success();
    }
}
