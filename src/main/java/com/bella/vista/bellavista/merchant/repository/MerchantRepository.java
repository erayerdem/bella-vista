package com.bella.vista.bellavista.merchant.repository;

import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface MerchantRepository extends ReactiveCrudRepository<Merchant,Long> {

    Mono<Merchant>findByNameIgnoreCase(String name);

    @Query("select m from Merchant m left join fetch  m.coffees")
    Mono<Merchant> findByIdFetchCoffees(Long id);
}
