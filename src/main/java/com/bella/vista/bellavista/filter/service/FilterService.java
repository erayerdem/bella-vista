package com.bella.vista.bellavista.filter.service;

import com.bella.vista.bellavista.filter.dto.FilterRequestDto;
import com.bella.vista.bellavista.filter.entity.Filter;

import java.util.List;

public interface FilterService {

    List<Filter> getFilters();
     Filter addFilter(FilterRequestDto req);
     void deleteFilter(Long id);
    Filter getById(Long id);
}
