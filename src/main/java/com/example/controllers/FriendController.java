package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "friend") String name) {
        return String.format("Hello, %s", name);
    }
}
