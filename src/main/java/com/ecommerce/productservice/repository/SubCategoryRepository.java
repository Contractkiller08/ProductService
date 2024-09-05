package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {

    Optional<SubCategory> findByName(String name);
}
