package com.example.exceptionHandling.repo;

import com.example.exceptionHandling.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
        Optional<Product> findProductById(Integer id);

}
