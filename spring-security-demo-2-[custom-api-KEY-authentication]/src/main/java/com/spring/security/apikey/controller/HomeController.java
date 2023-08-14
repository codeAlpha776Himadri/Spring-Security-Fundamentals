package com.spring.security.apikey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
    
    @GetMapping("/demo1") 
    public String demo1() {
        return "This is demo1 endpoint" ; 
    }

    @GetMapping("/demo3") 
    public String demo3() {
        return "This is demo3 endpoint" ; 
    }

    @PostMapping("/demo2")
    public String demo2() {
        return "This is demo2 endpoint" ; 
    }


}
