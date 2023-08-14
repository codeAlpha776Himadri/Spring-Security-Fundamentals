package com.spring.security.apikey.config.security.filters;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class DemoFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
        
        String username = request.getParameter("username") ; 
        String password = request.getParameter("password") ; 
        
        System.out.println("\nInside DemoFilter:: username : "+username+" | password : "+password+" \n");
        
        // just for demo 
        // in real app : this will be passed to authentication manager to provider
        if (
            username == null || 
            password == null || 
            !username.equals("username") || 
            !password.equals("password")    
        ) {
            PrintWriter out = response.getWriter() ;
            response.setContentType("text/html");
            out.print("Invalid username or password....") ; 
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.flush();
            return ; 
        }

        filterChain.doFilter(request, response);

        
    }
    
}
