package com.example.northwind.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;
@Data
@Entity
@Table(name="products")
public class Product implements IEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="product_id")
        private int id;
        @Column(name="product_name")
        @Size(min=2,max = 50) //min 2 harf ürün girilme kontrolü
        private String productName;
        @Column(name="unit_price")
        private double unitPrice;
        @Column(name="quantity_per_unit")
        private String quantityPerUnit;



    }
