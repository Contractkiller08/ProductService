package com.ecommerce.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("category")
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private String description;

}
