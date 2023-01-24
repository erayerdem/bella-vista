package com.bella.vista.bellavista.merchant.mapper;

import com.bella.vista.bellavista.common.mapper.BaseMapper;
import com.bella.vista.bellavista.merchant.dto.MerchantDto;
import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface MerchantMapper extends BaseMapper<Merchant, MerchantDto> {
}
