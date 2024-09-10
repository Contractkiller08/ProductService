package com.ecommerce.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProductDTO{

    private String id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    private int availableCount;
    @NotEmpty(message = "Price can't be empty")
    private double price;
    private String subCategoryId;
}
