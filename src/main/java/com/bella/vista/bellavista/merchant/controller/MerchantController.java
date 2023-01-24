package com.bella.vista.bellavista.merchant.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
