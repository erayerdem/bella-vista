package com.bella.vista.bellavista.common.mapper;

import org.mapstruct.Mapper;


public interface BaseMapper<S,D> {
    D toDto(S source);

}