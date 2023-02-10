package com.bella.vista.bellavista.receipt.repository;

import com.bella.vista.bellavista.receipt.entity.Receipt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceiptRepository extends PagingAndSortingRepository<Receipt,Long> {

    Receipt save(Receipt entity);
}
