package com.example.exceptionHandling.service;

import com.example.exceptionHandling.entity.Product;
import com.example.exceptionHandling.repo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void saveProduct() {
        Product product=new Product(196,"Nokia","Mobile","24000");
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product,productService.saveProduct(product));
    }
    @Test
    public void findProductById(){
        Product product=new Product(192,"Nokia","Mobile","25000");
        productRepository.save(product);
        assertNotNull(productRepository.findById(192).get());
    }

    @Test
    public void showAll(){
        when(productRepository.findAll()).thenReturn(Stream.of(
                new Product(192,"Nokia","Mobile","25000"),
                new Product(193,"Ps4","Gaming Console","37000")
        ).collect(Collectors.toList()));
        assertEquals(2,productService.showAll().size());
    }


}