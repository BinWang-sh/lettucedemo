package com.example.lettucedemo.controller;

import com.example.lettucedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping("/setuser")
    public String setUserTest() {

        userService.setUser();
        return "Done";
    }
}
