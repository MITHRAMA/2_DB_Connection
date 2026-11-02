package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;




@RestController 
public class Controller {
    @Autowired 
    private UserRepositor userRepositor;

    @GetMapping("/users")
    public void insert(){
        userRepositor.save(new UserEntity(1L, "John"));
    }
        
        
    }

