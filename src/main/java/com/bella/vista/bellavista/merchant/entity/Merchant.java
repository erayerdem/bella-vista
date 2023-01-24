package com.bella.vista.bellavista.merchant.entity;

import com.bella.vista.bellavista.coffee.dto.Coffee;
import com.bella.vista.bellavista.common.dto.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;


@Document(indexName = "merchant")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Merchant  {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;


    @Field(type = FieldType.Text)
    private City city;

    @Field(type = FieldType.Keyword)
    private String about;


    @Field(type = FieldType.Date)
    private OffsetDateTime createdDate;
    @Builder.Default
    private List<Coffee> coffees = Collections.emptyList();


}
