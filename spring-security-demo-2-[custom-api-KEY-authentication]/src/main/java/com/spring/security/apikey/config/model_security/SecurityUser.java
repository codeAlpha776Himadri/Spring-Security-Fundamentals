package com.spring.security.apikey.config.model_security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.security.apikey.model.User;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user ; 


    @Override
    public String getPassword() {
        return this.user.getPassword() ;
    }

    @Override
    public String getUsername() {
        return this.user.getUsername() ; 
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user
            .getAuthorities()
                .stream()
                .map(SecurityAuthority::new)
                .collect(Collectors.toList()) ;
    }


    
    @Override
    public boolean isAccountNonExpired() {
        return true ; 
    }

    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }
    
}
