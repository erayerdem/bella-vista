package com.bella.vista.bellavista.equipment.service;

import com.bella.vista.bellavista.equipment.dto.EquipmentRequestDto;
import com.bella.vista.bellavista.equipment.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getEquipments();
     Equipment addEquipment(EquipmentRequestDto req);
     void deleteEquipment(Long id);
    Equipment getById(Long id);
}
