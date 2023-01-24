package com.bella.vista.bellavista.merchant.repository;

import com.bella.vista.bellavista.merchant.entity.Merchant;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface MerchantRepository extends ElasticsearchRepository<Merchant,String> {




    @Query("""
            {
                 "term": {
                  "name": {
                    "value": "?0"
                  }
                }
              }
            """)
    Optional<Merchant> getByNameKeyword(String name);
}
