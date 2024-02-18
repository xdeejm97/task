package com.atipera.task.controller;

import com.atipera.task.model.GitHubDtoBranch;
import com.atipera.task.model.GitHubDtoRepository;
import com.atipera.task.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping(value = "/{username}", produces = "application/json")
    public List<GitHubDtoRepository> getRepositoryFromGitHub(@PathVariable("username") String username) {
        return gitHubService.getGitHubRepo(username);
    }

    @GetMapping(value = "/{username}/{nameRepo}", produces = "application/json")
    public List<GitHubDtoBranch> getBranchFromGitHub(@PathVariable("username") String username, @PathVariable("nameRepo") String nameRepository) {
        return gitHubService.getGitHubBranch(username, nameRepository);
    }
}