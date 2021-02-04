package com.example.northwind.dataaccess.abstracts;

import com.example.northwind.entities.concretes.Product;

public interface IProductDao {
    Product getProductById(Product product);//id alanına göre product getirsin
    Product addProduct(Product product);//product ekle
    Product updateProduct(Product product); //product güncelleme
    Product deleteProduct(Product product); //product silme
}
