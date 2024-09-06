package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.CategoryDTO;
import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // Creation of Category
    public Category createCategory(CategoryDTO categoryDTO){
        Category newcategory = new Category();
        newcategory.setName(categoryDTO.getName());
        newcategory.setDescription(categoryDTO.getDescription());

        return categoryRepository.save(newcategory);
    }
}
