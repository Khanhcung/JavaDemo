package com.shopdev.demo.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.shopdev.demo.entity.feed.FeedEntity;

import java.util.List;

@Data
@Entity
@Table(name = "jv_user_001")
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(columnDefinition = "nvarchar(255)",nullable = false,name ="Username")
    private String username;

    @Column(columnDefinition = "nvarchar(50)",nullable = false,name ="Email")
    private  String email;

    @Column(columnDefinition = "int", name ="Point"  )
    private int point;
    
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL,orphanRemoval =  true,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FeedEntity> feeds;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private PassportEntity passport;
}
