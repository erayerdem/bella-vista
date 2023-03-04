package com.bella.vista.bellavista.water.repository;

import com.bella.vista.bellavista.water.entity.Water;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface WaterRepository extends ReactiveCrudRepository<Water,Long> {
}
