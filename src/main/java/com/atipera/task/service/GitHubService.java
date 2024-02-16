package com.atipera.task.service;

import com.atipera.task.webClientGitHub.gitHub.GitHubClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final GitHubClient gitHubClient = new GitHubClient();

    public String getGitHubRepo(String username){
        gitHubClient.getRepoGitHub(username);
        return null;
    }


    public String getGitHubBranch(String username ,String nameRepository) {
        gitHubClient.getBranchGitHub(username, nameRepository);

        return null;
    }
}
