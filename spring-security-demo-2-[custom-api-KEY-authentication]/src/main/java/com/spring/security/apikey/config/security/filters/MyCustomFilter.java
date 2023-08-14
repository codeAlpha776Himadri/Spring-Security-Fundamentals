package com.spring.security.apikey.config.security.filters;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.security.apikey.config.security.authentication.MyCustomAuthentication;
import com.spring.security.apikey.config.security.manager.MyCustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class MyCustomFilter extends OncePerRequestFilter {


    private final MyCustomAuthenticationManager myCustomAuthenticationManager ;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException  {

        System.out.println("I am MyCustomFilter....");


        /** 
         *   1. create an authentication object which is not yet created {but contains credentials given by client (in this case it is secreat_key)} ....
         *   2. delegate the authentication object to the authentication manager ...
         *   3. get back the authentication object from the manager
         *   4. if the object is authenticated i.e {authentication.isAuthenticated()} returns {true}
         *   5. then set the authentication object in the { SecurityContextHolder } 
         *   6. so that it can later be used by { authorization filters } for authorization of further requests
         *   7. then delegate the request to the next filter in the chain.
         *   8. If {authentication.isAuthenticated()} returns { false }
         *   9. then send appropiate response to the client
        **/


        // Retrive the key & create new authentication object:
        String key = String.valueOf(request.getHeader("x-api-key")) ; // retrive the key from the request Header
        MyCustomAuthentication myCustomAuthentication = new MyCustomAuthentication(false , key) ;

        //get back the authentication obj from the {AuthenticationManager} :
        var authentication = this.myCustomAuthenticationManager.authenticate(myCustomAuthentication) ; 
        

        // check if authenticated:
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response); // only when authentication worked
        }
        else {
            
            PrintWriter out =  response.getWriter() ; 
            response.setContentType("text/html");
            out.print("Invalid Key...") ;
            out.flush();

        }

        
    }
    
}
