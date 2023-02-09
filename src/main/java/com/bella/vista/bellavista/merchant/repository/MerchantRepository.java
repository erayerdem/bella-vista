package com.bella.vista.bellavista.merchant.repository;

import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MerchantRepository extends ListCrudRepository<Merchant,Long> {

    Optional<Merchant>findByNameIgnoreCase(String name);
}
