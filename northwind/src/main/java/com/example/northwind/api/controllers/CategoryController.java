package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    
    @GetMapping("/categories")
    public List<Category> getAll(){
    	return categoryService.getAll();
    }

    @GetMapping("/categories/{category_id}")
    public Optional<Category> getByCategoryId(Category category){
        return categoryService.getByCategoryId(category);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id")Integer categoryId
                                                   ,@RequestBody Category category) throws Exception{
        Category categoryToUpdate =  categoryService.getByCategoryId(category)
                .orElseThrow(()->new Exception("No category"));
        categoryService.updateCategory(categoryToUpdate);
        return ResponseEntity.ok(categoryToUpdate);
    }

    @DeleteMapping("/categories/{category_id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id")Integer categoryId
            ,@RequestBody Category category) {
    	Category deletedCategory =  categoryService.getCategroyById(category.getID);
     categoryService.deleteCategory(deletedCategory);
     return ResponseEntity.ok(deletedCategory);
}}





