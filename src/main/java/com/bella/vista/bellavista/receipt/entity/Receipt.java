package com.bella.vista.bellavista.receipt.entity;

import com.bella.vista.bellavista.coffee.entity.Coffee;
import com.bella.vista.bellavista.common.entity.BaseEntity;
import com.bella.vista.bellavista.equipment.entity.Equipment;
import com.bella.vista.bellavista.filter.entity.Filter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne(optional = false)
    private Equipment equipment;
    @ManyToOne(optional = false)
    private Filter filter;
    @ManyToOne(optional = false)
    private Coffee coffee;
    private Integer temperature;

}
