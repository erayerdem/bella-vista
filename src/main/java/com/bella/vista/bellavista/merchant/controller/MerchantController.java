package com.bella.vista.bellavista.merchant.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.dto.MerchantCreateRequestDto;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import com.bella.vista.bellavista.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final MerchantService merchantService;

    @GetMapping
    public BaseResponse<List<MerchantDto>> getMerchants(){
        List<MerchantDto> merchants = merchantService.getMerchants();
        return BaseResponse.<List<MerchantDto>>builder().data(merchants).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Void> insertMerchant(@RequestBody MerchantCreateRequestDto merchant ){
        String capitalize = WordUtils.capitalize(StringUtils.normalizeSpace(merchant.merchantName()));
        Optional<Merchant> merchantByName = merchantService.getMerchantByName(capitalize);
        if (merchantByName.isEmpty()) {
            merchantService.saveMerchant(merchant,capitalize);
            return BaseResponse.success();
        }
        throw new RuntimeException("Merchant Already Exist");
    }
}
