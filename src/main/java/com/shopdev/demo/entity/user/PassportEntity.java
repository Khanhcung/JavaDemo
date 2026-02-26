package com.shopdev.demo.entity.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "jv_passport_001")
@Entity

public class PassportEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")

    private Long id;

    @Column(columnDefinition = "nvarchar(255)",nullable = false,name ="Number")
    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", nullable = false)
    private UserEntity user;
}
