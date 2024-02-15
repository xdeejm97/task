package com.atipera.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {

    @GetMapping("/")
    public String get(@PathVariable("repoName") String repoName, @PathVariable("login") String login){
        return "Hello";
    }
}