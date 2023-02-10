package com.bella.vista.bellavista.equipment.service;

import com.bella.vista.bellavista.equipment.dto.EquipmentRequestDto;
import com.bella.vista.bellavista.equipment.entity.Equipment;
import com.bella.vista.bellavista.equipment.repository.EquipmentRepository;
import com.bella.vista.bellavista.water.entity.Water;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {


    private final EquipmentRepository repo;
    @Override
    public List<Equipment> getEquipments() {
        return repo.findAll();
    }

    @Override
    public Equipment addEquipment(EquipmentRequestDto req) {
        var equipment = Equipment.builder().name(req.name()).build();
        return repo.save(equipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        Equipment entity = this.getById(id);
        repo.delete(entity);
    }

    @Override
    public Equipment getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipment Not Found"));
    }
}
