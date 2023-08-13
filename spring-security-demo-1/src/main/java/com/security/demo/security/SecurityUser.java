package com.security.demo.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.demo.model.User;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user ; 

    @Override
    public String getUsername() {
        return user.getUsername() ;   
    }

    @Override
    public String getPassword() {
        return user.getPassword() ; 
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
