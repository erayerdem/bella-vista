package com.bella.vista.bellavista.merchant.repository;

import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MerchantRepository extends ListCrudRepository<Merchant,Long> {

    Optional<Merchant>findByNameIgnoreCase(String name);

    @Query("select m from Merchant m left join fetch  m.coffees")
    Optional<Merchant> findByIdFetchCoffees(Long id);
}
