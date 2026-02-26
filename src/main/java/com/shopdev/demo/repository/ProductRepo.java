package com.shopdev.demo.repository;

import com.shopdev.demo.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends org.springframework.data.jpa.repository.JpaRepository<ProductEntity, Long> {

}
