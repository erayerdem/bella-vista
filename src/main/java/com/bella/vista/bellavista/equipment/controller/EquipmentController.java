package com.bella.vista.bellavista.equipment.controller;


import com.bella.vista.bellavista.common.dto.BaseResponse;
import com.bella.vista.bellavista.equipment.dto.EquipmentRequestDto;
import com.bella.vista.bellavista.equipment.entity.Equipment;
import com.bella.vista.bellavista.equipment.service.EquipmentService;
import com.bella.vista.bellavista.water.dto.WaterRequestDto;
import com.bella.vista.bellavista.water.entity.Water;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private  final EquipmentService equipmentService;
    @GetMapping
    public BaseResponse<List<Equipment>> getEquipments(){
        var waters = equipmentService.getEquipments();
        return BaseResponse.<List<Equipment>>builder().data(waters).build();
    }

    @PostMapping
    public BaseResponse<Equipment> addEquipment(@RequestBody EquipmentRequestDto req){
            return BaseResponse.<Equipment>builder().data(equipmentService.addEquipment(req)).build();
    }

    @DeleteMapping("{id}")
    public BaseResponse<Void> deleteWater(@PathVariable Long id) {
            equipmentService.deleteEquipment(id);
            return BaseResponse.success();
    }

    @GetMapping("{id}")
    public BaseResponse<Equipment> getWater(@PathVariable Long id) {
        var water = equipmentService.getById(id);
        return BaseResponse.<Equipment>builder().data(water).build();
    }
}
