package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.dto.Category;
import com.ecommerce.productservice.entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);
}
