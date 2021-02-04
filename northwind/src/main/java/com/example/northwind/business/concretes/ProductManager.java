package com.example.northwind.business.concretes;

import com.example.northwind.dataaccess.concretes.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductManager implements IProductService{
    @Autowired
    private ProductDao productDao;

    public List<Product> getAll(){
    	return productDao.findAll();
    }
    @Override
    public Optional<Product> getByProductId(Product product) {
    	int id = product.getId();
        return productDao.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        System.out.println(product.getProductName());
        if(product.getProductName().length()<2){
            System.out.println("2 karakterden az girdiniz..");
            return product;
        }
        else  {
        return productDao.save(product);
    }}

    @Override
    public Product updateProduct(Product product) {
    	int id = product.getId();
    	Product updatedProduct = productDao.findById(id);
    	updatedProduct.setProductName(product.getProductName);
    	updatedProduct.setUnitPrice(product.getUnitePrice);
    	updatedProduct.quantityPerUnit(product.getquantityPerUnit);
    	Product updatedProduct = productDao.save(updatedProduct);
        return updatedProduct;
    }

    @Override
    public Product deleteProduct(Product product) throws Exception{
        Product deletedProduct = productDao.findById(product.getId()).orElseThrow(()->new Exception("No product"));
        productDao.delete(deletedProduct);
        Map<String,Boolean> responce = new HashMap<>();
        responce.put("Silindi",Boolean.TRUE);
        return (Product) responce;
    }
}


