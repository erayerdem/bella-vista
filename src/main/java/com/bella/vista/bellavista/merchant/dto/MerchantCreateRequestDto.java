package com.bella.vista.bellavista.merchant.dto;

import com.bella.vista.bellavista.common.dto.City;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;


@JsonSerialize
@JsonDeserialize
public record MerchantCreateRequestDto (
        @Length(min = 3,max = 20,message = "Merchant name must be between ${min} and ${max}") String merchantName,
        @NotNull(message = "message can not be null") City city,
        @NotNull(message = "message can not be null") String about

        ) {
}
