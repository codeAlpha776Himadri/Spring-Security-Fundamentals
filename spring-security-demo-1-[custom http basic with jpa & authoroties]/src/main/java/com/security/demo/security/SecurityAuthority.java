package com.security.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.security.demo.model.Authority;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    

    private final Authority authority ;
   
   
    public String getAuthority() {
        return this.authority.getName() ;
    }

    

}
