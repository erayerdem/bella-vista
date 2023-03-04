package com.bella.vista.bellavista.receipt.service;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.coffee.service.CoffeeService;
import com.bella.vista.bellavista.equipment.entity.Equipment;
import com.bella.vista.bellavista.equipment.service.EquipmentService;
import com.bella.vista.bellavista.filter.entity.Filter;
import com.bella.vista.bellavista.filter.service.FilterService;
import com.bella.vista.bellavista.receipt.dto.ReceiptCreateDto;
import com.bella.vista.bellavista.receipt.entity.Receipt;
import com.bella.vista.bellavista.receipt.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService{

    private final ReceiptRepository repository;

    private final CoffeeService coffeeService;

    private final FilterService filterService;

    private final EquipmentService equipmentService;

    @Override
    public Flux<Receipt> receipts(Integer page, Integer size, String property, String... properties) {
        return repository.findAll(PageRequest.of(page,size,Sort.Direction.DESC,"id")).toList();
    }

    @Override
    public Mono<Receipt> createReceipt(ReceiptCreateDto dto) {
        Coffee coffee = coffeeService.getById(dto.coffeeId());
        Filter filter = filterService.getById(dto.filterId());
        Equipment equipment = equipmentService.getById(dto.equipmentId());

        Receipt receipt = Receipt.builder()
                .filter(filter)
                .equipment(equipment)
                .coffee(coffee)
                .temperature(dto.temperature())
                .build();

        return repository.save(receipt);

    }


}
