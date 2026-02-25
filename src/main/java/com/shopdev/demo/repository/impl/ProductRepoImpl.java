package com.shopdev.demo.repository.impl;

import com.shopdev.demo.entity.ProductEntity;
import com.shopdev.demo.repository.ProductRepo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public class ProductRepoImpl  implements ProductRepo {
    @Override
    public ProductEntity create(ProductEntity prod) {
        ProductEntity entity = new ProductEntity();
        entity.setId(1L);
        entity.setName("a");
        entity.setPrice(new BigDecimal("21.6"));
        return  entity;
    }

    @Override
    public List<ProductEntity> findAllProds() {
        ProductEntity entity = new ProductEntity();
        entity.setId(1L);
        entity.setName("a");
        entity.setPrice(new BigDecimal("21.6"));
        return List.of(entity);
    }
}
