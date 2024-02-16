package com.atipera.task.webClientGitHub.gitHub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class GitHubClient {

    private final String GITHUB_URL_REPOSITORY = "https://api.github.com/users/";
    private final String GITHUB_URL_BRANCH = "https://api.github.com/repos/";
    private RestTemplate restTemplate = new RestTemplate();

    public String getRepoGitHub(String username) {
        String s = restTemplate.getForObject(GITHUB_URL_REPOSITORY + username + "/repos", String.class);
        log.info(s);
        return null;
    }


    public String getBranchGitHub(String username, String nameRepository) {
        String s = restTemplate.getForObject(GITHUB_URL_BRANCH + username + "/"+ nameRepository + "/branches"
                ,String.class);
        log.info(s);
        return null;
    }
}
