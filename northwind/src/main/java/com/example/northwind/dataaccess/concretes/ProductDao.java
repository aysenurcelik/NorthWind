package com.example.northwind.dataaccess.concretes;

import com.example.northwind.dataaccess.abstracts.IProductDao;
import com.example.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.websocket.Session;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

}
