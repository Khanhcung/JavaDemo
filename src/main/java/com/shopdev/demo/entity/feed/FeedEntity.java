package com.shopdev.demo.entity.feed;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.shopdev.demo.entity.user.UserEntity;

@Entity
@Data
@Table(name = "jv_feed_001")
@DynamicInsert
@DynamicUpdate
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( columnDefinition = "nvarchar(100)",nullable = false)
    private String title;


    @Lob
    @Column( columnDefinition = "nvarchar(255)",nullable = true)
    private  String  description;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "UserId", nullable = true)
    private UserEntity user;

}
