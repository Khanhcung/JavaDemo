package com.shopdev.demo.services;

import com.shopdev.demo.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {
    ProductEntity create(ProductEntity prod);

    List<ProductEntity> findAllProds();
}
