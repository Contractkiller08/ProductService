package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.CategoryDTO;
import com.ecommerce.productservice.entity.Category;
import com.ecommerce.productservice.service.CategoryService;
import com.ecommerce.productservice.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    // Here we can use Global exception handler as well
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);    // status code 400
        }

        try{
            Category createdCategory = categoryService.createCategory(categoryDTO);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED); // status code 201
        }catch (Exception ex){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);// status code 500
        }
    }

    // update category. first check if id exists
    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable String categoryId,@Valid @RequestBody CategoryDTO categoryDTO){
        try{
            Category updatedCategory = categoryService.updateCategory(categoryId, categoryDTO);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);//
        }
    }

}
