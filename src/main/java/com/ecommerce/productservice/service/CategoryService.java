package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.CategoryDTO;
import com.ecommerce.productservice.entity.Category;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(String categoryId, CategoryDTO categoryDTO);



}
