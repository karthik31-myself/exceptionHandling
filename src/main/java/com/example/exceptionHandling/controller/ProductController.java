package com.example.exceptionHandling.controller;

import com.example.exceptionHandling.entity.Product;
import com.example.exceptionHandling.exceptionHandle.ProductNotFound;
import com.example.exceptionHandling.repo.ProductRepository;
import com.example.exceptionHandling.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        log.info("Inside saveProduct method of ProductController");
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Integer id) throws ProductNotFound {
        log.info("Inside findProductById method of ProductController");
        return productService.findProductById(id);
    }

    @GetMapping("/showall")
    public List<Product> showAll(){
        return productService.showAll();
    }
}





