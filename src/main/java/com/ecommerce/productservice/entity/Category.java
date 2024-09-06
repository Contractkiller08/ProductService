package com.ecommerce.productservice.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("category")
@Data
@Builder
public class Category {
    @Id
    private String id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotEmpty(message = "description can't be empty")
    private String description;

}
