package com.security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.demo.dao.UserRepository;
import com.security.demo.security.SecurityUser;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        var user = this.userRepository.findUserByUsername(username); 
        // System.out.println(user.get());   // :Debug
        
        return user
            .map(SecurityUser::new) // same as (user -> new SecurityUser(user))
            .orElseThrow(() -> new UsernameNotFoundException("username: { "+username +" } not found...")) ;
    }
    
}
