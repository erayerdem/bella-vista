package com.bella.vista.bellavista.equipment.repository;

import com.bella.vista.bellavista.equipment.entity.Equipment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EquipmentRepository extends ReactiveCrudRepository<Equipment,Long> {
}
