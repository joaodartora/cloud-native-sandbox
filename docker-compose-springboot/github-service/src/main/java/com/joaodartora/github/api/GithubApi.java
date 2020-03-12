package com.joaodartora.github.api;

import java.io.IOException;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.joaodartora.github.model.GithubUser;

@Component
public class GithubApi {

	private RepositoryService service;

	public ResponseEntity getGithubRepositories (String user){
		
		service = new RepositoryService();
	
		try {
			return new ResponseEntity<GithubUser>(new GithubUser(user, service.getRepositories(user).size()), HttpStatus.OK);
		} catch (IOException exception) {
			return new ResponseEntity<Exception>(exception, HttpStatus.NOT_FOUND);
		}
	}
}
