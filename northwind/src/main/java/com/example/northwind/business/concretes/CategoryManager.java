package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.ICategoryService;

import com.example.northwind.dataaccess.concretes.CategoryDao;
import com.example.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryDao categoryDao;
    

    public List<Category> getAll(){
    	return categoryDao.findAll();    }
    @Override
    public Optional<Category> getByCategoryId(Category category) {
    	int categoryId = category.getId();
        return categoryDao.findById(categoryId);
    }

    @Override
    public Category addCategory(Category category) {
        maxProduct(category);
        return (Category) categoryDao.save(category);

    }

    @Override
    public Category updateCategory(Category category) {
        maxProduct(category);
        int categoryId = category.getId();
        Category categoryToUpdate =categoryDao.findById(categoryId)
        categoryToUpdate.setName(category.getyName());
    }


    public Category deleteCategory(Category category) throws Exception {
        Category deletedCategory = categoryDao.findById(category.getId()).orElseThrow(() -> new Exception("No product"));
        categoryDao.delete(deletedCategory);
        Map<String, Boolean> responce = new HashMap<>();
        responce.put("Silindi", Boolean.TRUE);
        return (Category) responce;
    }


    @Override
    public void maxProduct(Category category) {
        List<String> categoryList=new ArrayList<String>();
        if(categoryList.size()>10){
            System.out.println("Bir kategori sadece 10 ürün listeler");

        }

    }
}
