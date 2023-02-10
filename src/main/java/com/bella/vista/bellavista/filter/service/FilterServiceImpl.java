package com.bella.vista.bellavista.filter.service;

import com.bella.vista.bellavista.filter.dto.FilterRequestDto;
import com.bella.vista.bellavista.filter.entity.Filter;
import com.bella.vista.bellavista.filter.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {


    private final FilterRepository repo;
    @Override
    public List<Filter> getFilters() {
        return repo.findAll();
    }

    @Override
    public Filter addFilter(FilterRequestDto req) {
        var equipment = Filter.builder().name(req.name()).build();
        return repo.save(equipment);
    }

    @Override
    public void deleteFilter(Long id) {
        Filter entity = this.getById(id);
        repo.delete(entity);
    }

    @Override
    public Filter getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Filter Not Found"));
    }
}
