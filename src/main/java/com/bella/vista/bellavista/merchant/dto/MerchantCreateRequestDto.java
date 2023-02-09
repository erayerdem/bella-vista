package com.bella.vista.bellavista.merchant.dto;

import com.bella.vista.bellavista.common.dto.City;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;



public record MerchantCreateRequestDto (
        @Length(min = 3,max = 20,message = "Merchant name must be between ${min} and ${max}") String merchantName,
        @NotNull(message = "message can not be null") City city,
        @NotNull(message = "message can not be null") String about

        ) {
}
