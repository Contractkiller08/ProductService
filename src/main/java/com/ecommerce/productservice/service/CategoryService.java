package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.CategoryDTO;
import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.exception.CategoryNotFoundException;
import com.ecommerce.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // Creation of Category
    public Category createCategory(CategoryDTO categoryDTO){
        var newcategory = Category.builder().name(categoryDTO.getName()).description(categoryDTO.getDescription()).build();

        return categoryRepository.save(newcategory);
    }

    //updation of category
    public Category updateCategory(String categoryId, CategoryDTO categoryDTO){
        //check if category already exists or not
        Optional<Category> categId = categoryRepository.findById(categoryId);

        if(categId.isPresent()){
            Category existingCateg = categId.get();
            existingCateg.setName(categoryDTO.getName());
            existingCateg.setDescription(categoryDTO.getDescription());
            return categoryRepository.save(existingCateg);
        }else{
            throw new CategoryNotFoundException("Category with ID " + categoryId + " not found.");
        }
    }

}
