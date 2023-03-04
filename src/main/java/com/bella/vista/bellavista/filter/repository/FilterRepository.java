package com.bella.vista.bellavista.filter.repository;

import com.bella.vista.bellavista.filter.entity.Filter;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FilterRepository extends ReactiveCrudRepository<Filter,Long> {
}
