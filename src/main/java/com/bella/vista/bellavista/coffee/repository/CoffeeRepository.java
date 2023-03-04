package com.bella.vista.bellavista.coffee.repository;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeRepository extends ReactiveCrudRepository<Coffee,Long> { }
