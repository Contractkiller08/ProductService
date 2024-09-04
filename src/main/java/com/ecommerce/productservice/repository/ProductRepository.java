package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByName(String name);

    List<Product> findByAvailableCount(int count);

    List<Product> findBySubCategory(SubCategory subCategory);

    List<Product> findBySubCategoryId(String subCategoryId);
}
