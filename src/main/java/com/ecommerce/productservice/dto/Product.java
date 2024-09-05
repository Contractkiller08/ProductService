package com.ecommerce.productservice.dto;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private int availableCount;
    private double price;
    private String subCategoryId;
}
