package com.bella.vista.bellavista.merchant.entity;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.common.dto.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "merchant")
public class Merchant  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "merchant_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private City city;

    private String about;

    private OffsetDateTime createdDate;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id")
    private Set<Coffee> coffees;

    public void putCoffee(Set<Coffee> cofffe){
        if (Objects.isNull(coffees))
            coffees = Collections.emptySet();
        coffees.addAll(cofffe);
    }
}
