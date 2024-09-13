package com.ecommerce.productservice.service.impl;

import com.ecommerce.productservice.dto.CategoryDTO;
import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.exception.CategoryNotFoundException;
import com.ecommerce.productservice.repository.CategoryRepository;
import com.ecommerce.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // Creation of Category
    @Override
    public Category createCategory(CategoryDTO categoryDTO){
        var newcategory = Category.builder().name(categoryDTO.getName()).description(categoryDTO.getDescription()).build();

        return categoryRepository.save(newcategory);
    }

    //updation of category
    @Override
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

    //Fetch all categories
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //delete the category

    public void deleteById(String id){
        categoryRepository.deleteById(id);
    }

}
