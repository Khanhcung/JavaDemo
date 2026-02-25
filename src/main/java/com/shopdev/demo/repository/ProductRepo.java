package com.shopdev.demo.repository;

import com.shopdev.demo.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ProductRepo {
    ProductEntity create(ProductEntity prod);

    List<ProductEntity> findAllProds();
}
