package com.atipera.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {

    @GetMapping("/")
    public String get(){
        return "Hello";
    }
}
git