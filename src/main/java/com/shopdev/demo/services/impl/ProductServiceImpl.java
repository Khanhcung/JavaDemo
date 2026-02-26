package com.shopdev.demo.services.impl;

import com.shopdev.demo.entity.ProductEntity;
import com.shopdev.demo.repository.ProductRepo;
import com.shopdev.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductEntity create(ProductEntity prod) {
        return prod;
    }

    @Override
    public List<ProductEntity> findAllProds() {
        return null;
    }
}
