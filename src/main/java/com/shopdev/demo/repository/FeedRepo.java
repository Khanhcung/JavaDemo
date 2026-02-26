package com.shopdev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopdev.demo.entity.feed.FeedEntity;


@Repository
public interface FeedRepo extends JpaRepository<FeedEntity, Long> {
    
}
