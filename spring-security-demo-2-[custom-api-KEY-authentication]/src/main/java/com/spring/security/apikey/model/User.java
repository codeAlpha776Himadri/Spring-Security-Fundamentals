package com.spring.security.apikey.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ; 

    @Column(name = "username")
    private String username ;

    @Column(name = "password")
    private String password ; 

    
    @ManyToAny(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_authorities" , 
        joinColumns = @JoinColumn(name = "user_id") , 
        inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities ; 

}
