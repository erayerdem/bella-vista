package com.bella.vista.bellavista.common.mapper;

public interface BaseMapper<S,D> {
    D toDto(S source);
    S  toEntity(D source);
}