package com.ecommerce.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sub-category")
@Data
public class SubCategory {
    @Id
    private String id;
    private String name;
    private String description;

    @DBRef
    private Category category;
}
