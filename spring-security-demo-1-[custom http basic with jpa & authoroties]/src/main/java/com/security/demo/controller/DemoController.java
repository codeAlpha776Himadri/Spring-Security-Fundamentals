package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    
    @GetMapping("/demo1")
    public String demoEndPoint1() {
        return "Hello, i am demoEndPoint1" ; 
    }

    @GetMapping("/demo2")
    public String demoEndPoint2() {
        return "Hello, i am demoEndPoint2" ; 
    }

    @PostMapping("/demo3")
    public String demoEndPoint3() {
        return "Hello, i am demoEndPoint3" ; 
    }

}
