package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Category;

import java.util.Optional;

public interface ICategoryService {
    Optional<Category> getByCategoryId(Category category);
    Category addCategory(Category category);
    Category updateCategory(Category category);
    Category deleteCategory(Category category) throws Exception;
    void maxProduct(Category category);//10 ürün olabilir n=10
}
