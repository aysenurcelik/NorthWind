package com.example.northwind.dataaccess.abstracts;

import java.util.List;

import com.example.northwind.entities.concretes.Category;


public interface ICategroyDao {
	List<Category> getAll();
    Category getCategroyById(Category categroy);
    Category addCategroy(Category categroy);
    Category updateCategroy(Category categroy);
    Category deleteCategroy(Category categroy);
    int maxProduct(int n);//10 ürün olabilir n=10
}