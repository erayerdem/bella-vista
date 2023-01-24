package com.bella.vista.bellavista.merchant.service;

import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;

import java.util.List;

public interface MerchantService {

    List<MerchantDto> getMerchants();
}
