package com.shopdev.demo.repository;

public interface OrderRepo
        extends org.springframework.data.jpa.repository.JpaRepository<com.shopdev.demo.entity.OrderEntity, Long> {
}
