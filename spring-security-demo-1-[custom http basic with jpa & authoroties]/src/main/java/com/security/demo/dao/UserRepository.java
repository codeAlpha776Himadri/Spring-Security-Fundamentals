package com.security.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.security.demo.model.User;


// @Repository -- dont user stereotype annotations above interfaces
public interface UserRepository extends JpaRepository<User, Integer> {

    
    @Query("""
        SELECT u FROM User u WHERE u.username = :username         
    """)
    public Optional<User> findUserByUsername(String username) ;



    @Query("""
        SELECT u FROM User u WHERE u.username = :username AND u.password = :password          
    """)
    public Optional<User> findUserByUsernameAndPassword(String username, String password) ;


}
