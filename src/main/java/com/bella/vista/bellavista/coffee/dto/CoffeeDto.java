package com.bella.vista.bellavista.coffee.dto;

import com.bella.vista.bellavista.common.dto.City;

public record CoffeeDto ( String fullName,
        City country,
        String  area,
        String station,
        String operation,
        String variety,
        String altitude,  // todo : doit enum
        String profile, // todo do enum
        Double tastingPoints) { }
