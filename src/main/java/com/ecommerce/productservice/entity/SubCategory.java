package com.ecommerce.productservice.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sub-category")
@Data
public class SubCategory {
    @Id
    private String id;

    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotEmpty(message = "description can't be empty")
    private String description;

    @DBRef
    private Category category;
}
