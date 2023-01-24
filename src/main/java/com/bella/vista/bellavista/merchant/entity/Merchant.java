package com.bella.vista.bellavista.merchant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "merchant")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Merchant {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;
}
