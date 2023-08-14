package com.spring.security.apikey.config.security.authentication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/*  
    ----------------------------------------------
    This is also called as authorization contract:
    ----------------------------------------------
*/ 


@AllArgsConstructor
@Getter
@Setter
public class MyCustomAuthentication implements Authentication {


    private final boolean isAuthenticated ; 
    private final String key ; 

    // There could be more fields ::: final vars can be set only using contructor
    // private final String username ; 
    // private final String password ;

    // important methods - start //

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated ;
    }


    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

        // we will not be needing this as we will be creating new instance of correct authentication and delegate that 
    }

    // important method - end //





    // garbage methods - start

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read") ;
    }

    @Override
    public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    // garbage methods - end
    
}
