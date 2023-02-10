package com.bella.vista.bellavista.filter.entity;


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
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "filter_generator")
    @SequenceGenerator(name = "filter_generator", sequenceName = "filter_seq",allocationSize = 1)
    @Column(name = "id", nullable = false,updatable = false,columnDefinition = "integer default nextval('filter_seq')")
    private Long id;
    private String name;

}
