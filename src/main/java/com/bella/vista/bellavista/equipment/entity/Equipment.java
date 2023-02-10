package com.bella.vista.bellavista.equipment.entity;


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
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "equipment_generator")
    @SequenceGenerator(name = "equipment_generator", sequenceName = "equipment_seq",allocationSize = 1)
    @Column(name = "id", nullable = false,updatable = false,columnDefinition = "integer default nextval('equipment_seq')")
    private Long id;
    private String name;

}
