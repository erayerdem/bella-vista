package com.bella.vista.bellavista.merchant.repository;

import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MerchantRepository extends ElasticsearchRepository<Merchant,String> {

}
