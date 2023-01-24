package com.bella.vista.bellavista.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.util.List;


@Document(indexName = "merchant")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String  email;

    @Field(type = FieldType.Keyword)
    private String about;

    private List<String > comments;
}
