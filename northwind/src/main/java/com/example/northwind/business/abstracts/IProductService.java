package com.example.northwind.business.abstracts;


import java.util.Optional;

import com.example.northwind.entities.concretes.Product;

import java.util.List;
public interface IProductService {
     List<Product> getAll();
     Optional<Product> getByProductId(Product product);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Product product) throws Exception;


}
