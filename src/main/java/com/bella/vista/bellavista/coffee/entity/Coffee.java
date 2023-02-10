package com.bella.vista.bellavista.coffee.entity;

import com.bella.vista.bellavista.common.dto.City;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;


@Entity
@Getter
@Setter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NaturalId
    private String fullName;

    @Enumerated(EnumType.ORDINAL)
    private City country;
    private String  area;
    private String station;
    private String operation;
    private String variety;
    private String altitude;  // todo : doit enum
    private String profile;  // todo do enum

    /*@Convert(converter = NumericBooleanConverter.class) // todo
    private List<String> tastingNotes;*/

    private Double tastingPoints;

}
