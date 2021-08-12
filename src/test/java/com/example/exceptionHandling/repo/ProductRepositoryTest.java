package com.example.exceptionHandling.repo;

import com.example.exceptionHandling.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Product product=Product
                .builder()
                .id(8)
                .name("Samsung-Tv")
                .type("Tv")
                .cost("32000")
                .build();
        testEntityManager.persist(product);
    }

    @Test
    public void findProductById(){
        Product product=productRepository.findById(8).get();
        assertEquals(product.getName(),"Samsung");
    }

}