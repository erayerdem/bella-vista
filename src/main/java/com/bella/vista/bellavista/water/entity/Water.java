package com.bella.vista.bellavista.water.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
public class Water {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "water_generator")
    @SequenceGenerator(name = "water_generator", sequenceName = "water_sequence",allocationSize = 1)
    @Column(name = "id", nullable = false,updatable = false,columnDefinition = "integer default nextval('water_sequence')")
    private Long id;
    private String name;

}
