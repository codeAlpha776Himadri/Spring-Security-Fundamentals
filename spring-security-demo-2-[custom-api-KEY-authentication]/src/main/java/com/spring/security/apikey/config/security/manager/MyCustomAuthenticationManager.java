package com.spring.security.apikey.config.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.spring.security.apikey.config.security.authentication.MyCustomAuthentication;
import com.spring.security.apikey.config.security.provider.MyCustomAuthenticationProvider1;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class MyCustomAuthenticationManager implements AuthenticationManager {


    private final MyCustomAuthenticationProvider1 myCustomAuthenticationProvider1 ;


    // we can  have multiple providers configured : 
    // e.g : 
    // private final MyCustomAuthenticationProvider2 myCustomAuthenticationProvider2 ;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        System.out.println("I am MyCustom-Manager....");

        // we call the authentication provider with the {authentication object}
        
        if (this.myCustomAuthenticationProvider1.supports(MyCustomAuthentication.class)) {
            return this.myCustomAuthenticationProvider1.authenticate(authentication) ;
        }

        /* 
            Like below you can chain with multiple providers :

            else if (this.myCustomAuthenticationProvider2.supports......) ....
        */

        throw new BadCredentialsException("Invalid Key!!") ;

    }
 
}
