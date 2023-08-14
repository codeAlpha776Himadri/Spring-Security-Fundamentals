package com.spring.security.apikey.config.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.spring.security.apikey.config.security.authentication.MyCustomAuthentication;


@Component
public class MyCustomAuthenticationProvider1 implements AuthenticationProvider {

    @Value("${our.secreat.key}")
    private String key  ; 

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("I am MyCustom-Provider1....");

        MyCustomAuthentication myCustomAuthentication = (MyCustomAuthentication) authentication ;
        if (myCustomAuthentication.getKey().equals(this.key)) {
            return new MyCustomAuthentication(true, null) ;
        }
        throw  new BadCredentialsException("Incorrect key!!") ; 
    }

    @Override
    public boolean supports(Class<?> authentication) {

        System.out.println("I am Support check of Provider1....");

        // just like this we can have multiple number of prividers that tries to 
        // match with specific type of authentication object :
        return MyCustomAuthentication.class.equals(authentication) ;
    }
    
}
