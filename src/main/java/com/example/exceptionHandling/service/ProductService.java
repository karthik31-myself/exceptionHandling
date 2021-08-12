package com.example.exceptionHandling.service;

import com.example.exceptionHandling.entity.Product;
import com.example.exceptionHandling.exceptionHandle.ProductNotFound;
import com.example.exceptionHandling.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        //Logger log= LoggerFactory.getLogger(ProductService.class);
        log.info("Inside saveProduct of ProductService");
        return productRepository.save(product);
    }

    public Product findProductById(Integer id) throws ProductNotFound {
        Optional<Product> product=
                productRepository.findProductById(id);
        if (!product.isPresent()) {
            throw new ProductNotFound("Product Not found!");
        }
        else{
            return product.get();
        }
    }

    public List<Product> showAll() {
        return productRepository.findAll();
    }
}
