package com.example.northwind.dataaccess.concretes;
import com.example.northwind.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
