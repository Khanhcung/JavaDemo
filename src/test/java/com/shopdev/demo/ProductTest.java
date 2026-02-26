package com.shopdev.demo;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.shopdev.demo.entity.OrderEntity;
import com.shopdev.demo.entity.ProductEntity;
import com.shopdev.demo.repository.OrderRepo;
import com.shopdev.demo.repository.ProductRepo;

import jakarta.transaction.Transactional;
import lombok.experimental.var;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Test
    @Transactional
    @Rollback(false)

    void manyToManyTest() {
        // Create products and orders, set up relationships, and save to the database

        ProductEntity prod = new ProductEntity();
        ProductEntity prod1 = new ProductEntity();

        OrderEntity order = new OrderEntity();
        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();

        prod.setName("Test Product");
        prod1.setName("Test Product 1");
        prod.setPrice(new BigDecimal("100.00"));
        prod1.setPrice(new BigDecimal("110.00"));

        order.setUserId(1);
        order1.setUserId(2);
        order2.setUserId(3);

        prod.setOrders(new java.util.ArrayList<>(java.util.List.of(order, order1)));
        prod1.setOrders(new java.util.ArrayList<>(java.util.List.of(order2, order)));

        orderRepo.save(order);
        orderRepo.save(order1);
        orderRepo.save(order2);

        productRepo.save(prod);
        productRepo.save(prod1);

    }

    @Test
    @Transactional

    void selectManyTest() {
        ProductEntity prod = productRepo.findById(1L).orElse(null);
        System.out.println(prod);
        System.out.println(prod.getOrders());
    }
}
