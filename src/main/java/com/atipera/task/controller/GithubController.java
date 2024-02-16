package com.atipera.task.controller;

import com.atipera.task.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GithubController {


    private final GitHubService gitHubService;

    @GetMapping("/{username}")
    public String get(@PathVariable("username") String username) {
        gitHubService.getGitHubRepo(username);
        return null;
    }

    @GetMapping("/{username}/{nameRepo}")
    public String getBranch(@PathVariable("username") String username ,@PathVariable("nameRepo") String nameRepository) {
        gitHubService.getGitHubBranch(username,nameRepository);

        return null;
    }
}