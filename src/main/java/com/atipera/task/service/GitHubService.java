package com.atipera.task.service;

import com.atipera.task.model.GitHubDtoBranch;
import com.atipera.task.model.GitHubDtoRepository;
import com.atipera.task.webClientGitHub.GitHubClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final GitHubClient gitHubClient;

    public List<GitHubDtoRepository> getGitHubRepo(String username) {
        return gitHubClient.getRepoGitHub(username);

    }

    public List<GitHubDtoBranch> getGitHubBranch(String username, String nameRepository) {
        return gitHubClient.getGitHubBranch(username, nameRepository);

    }
}
