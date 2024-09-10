package com.ecommerce.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDTO {
    private String id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotEmpty(message = "description can't be empty")
    private String description;
}
