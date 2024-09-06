package com.ecommerce.productservice.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Data
public class Product {
    @Id
    private String id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    private int availableCount;
    @NotEmpty(message = "price can't be empty")
    private double price;

    @DBRef
    private SubCategory subCategory;
}
