package com.spring.security.apikey.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.security.apikey.model.User;

public interface JpaUserRepository extends JpaRepository<User, Integer>  {
    
    @Query("""
        select u from User u where u.username = :username     
    """)
    public Optional<User> findUserByUsername(String username) ;

}
