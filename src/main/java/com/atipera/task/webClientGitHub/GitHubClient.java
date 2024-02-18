package com.atipera.task.webClientGitHub;

import com.atipera.task.exception.ResponseNotFoundException;
import com.atipera.task.model.GitHubDtoBranch;
import com.atipera.task.model.GitHubDtoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GitHubClient {

    private final String GITHUB_URL_REPOSITORY = "https://api.github.com/users/";
    private final String GITHUB_URL_BRANCH = "https://api.github.com/repos/";
    private RestTemplate restTemplate = new RestTemplate();

    public List<GitHubDtoRepository> getRepoGitHub(String username) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<List<GitHubDtoRepository>> responseEntity = restTemplate.exchange(GITHUB_URL_REPOSITORY + "{username}/repos"
                    , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<GitHubDtoRepository>>() {
                    }, username);

            return responseEntity.getBody();
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseNotFoundException(HttpStatus.valueOf(404), "Provided wrong username");
            } else {
                throw exception;
            }
        }
    }

    public List<GitHubDtoBranch> getGitHubBranch(String username, String nameRepository) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

        try {

            ResponseEntity<List<GitHubDtoBranch>> responseEntity = restTemplate.exchange(GITHUB_URL_BRANCH + "{username}/{nameRepository}/branches",
                    HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<GitHubDtoBranch>>() {
                    }, username, nameRepository);

            return responseEntity.getBody();

        } catch (HttpClientErrorException exception) {

            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseNotFoundException(HttpStatus.NOT_FOUND, "Provided wrong username");
            } else {
                throw exception;
            }
        }
    }
}
