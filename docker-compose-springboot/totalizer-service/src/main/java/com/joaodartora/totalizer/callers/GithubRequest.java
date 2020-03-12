package com.joaodartora.totalizer.callers;

import com.joaodartora.totalizer.model.GithubUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubRequest {

	@Value("${GITHUB_URL}")
    private String githubUrl;
	
	public GithubUser getGithubUser(String user) {
        	return new RestTemplate().getForObject(githubUrl+user, GithubUser.class);
	}
}

