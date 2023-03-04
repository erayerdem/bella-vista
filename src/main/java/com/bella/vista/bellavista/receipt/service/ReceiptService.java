package com.bella.vista.bellavista.receipt.service;

import com.bella.vista.bellavista.receipt.dto.ReceiptCreateDto;
import com.bella.vista.bellavista.receipt.entity.Receipt;
import jakarta.persistence.criteria.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReceiptService {
    Flux<Receipt> receipts(Integer page, Integer size, String property, String... properties);

    Mono<Receipt> createReceipt(ReceiptCreateDto dto);
}
