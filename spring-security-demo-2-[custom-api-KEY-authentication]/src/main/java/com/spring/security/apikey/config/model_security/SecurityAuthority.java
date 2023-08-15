package com.spring.security.apikey.config.model_security;

import org.springframework.security.core.GrantedAuthority;

import com.spring.security.apikey.model.Authority;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority ;

    @Override
    public String getAuthority() {
        return this.authority.getName() ;
    }



}
