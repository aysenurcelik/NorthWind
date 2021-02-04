package com.example.northwind.api.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;
@RestController
@RequestMapping("/api/v1")
public class ProductsController {
    @Autowired
    IProductService productService;
    
    @GetMapping("/products")
    public List<Product> getAll(){
           return productService.getAll();
      }

    @GetMapping("/products/{product_id}")
  public Optional<Product> getByProductId(@PathVariable(value="id")Product product){
         return productService.getByProductId(product);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @PutMapping("/customers")
    public ResponseEntity<Product> update(@PathVariable(value = "id")Integer productId
            ,@RequestBody Product product) throws Exception{
        Product productToUpdate =  productService.getByProductId(product)
                .orElseThrow(()->new Exception("No product"));
        productService.updateProduct(productToUpdate);
        return ResponseEntity.ok(productToUpdate);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id")Integer productId
    		,@RequestBody Product product) {
    	Product deletedProduct =  productService.getByProductId(product.productId);
    	productService.deleteProduct(deletedProduct);
    	return ResponseEntity.ok(deletedProduct);
    }
}





