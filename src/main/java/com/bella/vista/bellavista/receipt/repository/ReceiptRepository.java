package com.bella.vista.bellavista.receipt.repository;

import com.bella.vista.bellavista.receipt.entity.Receipt;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ReceiptRepository extends ReactiveCrudRepository<Receipt,Long> {

    Mono<Receipt> save(Receipt entity);
}
