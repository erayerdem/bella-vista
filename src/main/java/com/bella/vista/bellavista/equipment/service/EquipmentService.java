package com.bella.vista.bellavista.equipment.service;

import com.bella.vista.bellavista.equipment.dto.EquipmentRequestDto;
import com.bella.vista.bellavista.equipment.entity.Equipment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EquipmentService {

    Flux<Equipment> getEquipments();
    Mono<Equipment> addEquipment(EquipmentRequestDto req);
    void deleteEquipment(Long id);
    Mono<Equipment> getById(Long id);
}
