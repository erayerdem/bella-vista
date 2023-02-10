package com.bella.vista.bellavista.receipt.service;

import com.bella.vista.bellavista.receipt.dto.ReceiptCreateDto;
import com.bella.vista.bellavista.receipt.entity.Receipt;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface ReceiptService {
    List<Receipt> receipts(Integer page, Integer size, String property, String... properties);

    Receipt createReceipt(ReceiptCreateDto dto);
}
