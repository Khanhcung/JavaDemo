package com.shopdev.demo.controller;


import com.shopdev.demo.entity.ProductEntity;
import com.shopdev.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ProductEntity create(ProductEntity entity)
    {
        return  productService.create(entity);
    }

    @GetMapping("/products")
    public List<ProductEntity> findAll()
    {
        return  productService.findAllProds();
    }
}
