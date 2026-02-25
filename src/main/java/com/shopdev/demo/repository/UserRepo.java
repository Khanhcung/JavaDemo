package com.shopdev.demo.repository;

import com.shopdev.demo.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {


    UserEntity findByUsernameAndEmail(String userName,String email);

    List<UserEntity> findByUsernameStartingWith(String userName);


    @Query(" Select u from UserEntity u where u.id = (select max(p.id)  from UserEntity p ) ")
    UserEntity findMaxId();

    @Query(" Select u from UserEntity u where u.username = :username and u.email = :email ")
    List<UserEntity> getUserEntityBy(@Param("username") String userName, @Param("email") String email);


    @Query(" Select u from UserEntity u where u.username = ?1 and u.email = ?2 ")
    List<UserEntity> getUserEntityByTwo( String userName,  String email);

    //pageable

    Page<UserEntity> findByUsername(String username, Pageable pageable);

    // update delete
    @Modifying
    @Query("update  UserEntity  u set u.username = :username " )
    @Transactional
    int updateUserName( @Param("username") String username);


    //native sql


    @Query(value = " select count(id) from jv_user_001 ", nativeQuery = true)
    long getTotalUser();


}
