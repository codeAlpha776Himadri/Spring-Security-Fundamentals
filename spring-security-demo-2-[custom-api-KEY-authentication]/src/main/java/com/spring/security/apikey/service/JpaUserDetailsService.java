package com.spring.security.apikey.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.apikey.config.model_security.SecurityUser;
import com.spring.security.apikey.dao.JpaUserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final JpaUserRepository jpaUserRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.jpaUserRepository.findUserByUsername(username) ;
        return user
            .map(SecurityUser::new)
            .orElseThrow(() -> new UsernameNotFoundException("user with username: "+username+" not found...")) ;
    }
    
}
