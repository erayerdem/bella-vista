package com.bella.vista.bellavista.coffee.dto;


import com.bella.vista.bellavista.common.dto.City;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Coffee {

    private String fullName;
    private City country;
    private String  area;
    private String station;
    private String operation;
    private String variety;
    private String altitude;  // todo : doit enum
    private String profile;  // todo do enum
    private List<String> tastingNotes;
    private Double tastingPoints;
}
