package com.shopdev.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Data
@Table(name = "jv_product_001")
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "decimal(15,2)", nullable = false)
    private BigDecimal price;

    @ManyToAny(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinTable(name = "jv_product_order_001", joinColumns = @jakarta.persistence.JoinColumn(name = "product_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "order_id"))
    private List<OrderEntity> orders = new ArrayList<>();

}
