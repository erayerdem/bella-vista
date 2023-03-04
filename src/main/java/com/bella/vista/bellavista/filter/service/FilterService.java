package com.bella.vista.bellavista.filter.service;

import com.bella.vista.bellavista.filter.dto.FilterRequestDto;
import com.bella.vista.bellavista.filter.entity.Filter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilterService {

    Flux<Filter> getFilters();
     Mono<Filter> addFilter(FilterRequestDto req);
     void deleteFilter(Long id);
    Mono<Filter> getById(Long id);
}
