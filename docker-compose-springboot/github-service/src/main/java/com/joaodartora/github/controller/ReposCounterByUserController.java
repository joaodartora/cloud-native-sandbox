package com.joaodartora.github.controller;

import javax.ws.rs.Produces;

import com.joaodartora.github.api.GithubApi;
import com.joaodartora.github.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.joaodartora.github")
public class ReposCounterByUserController {

	@Autowired
	private GithubApi counter;
	
	@RequestMapping(value="/github/{user}", method = RequestMethod.GET)
	@Produces("application/json")
	public ResponseEntity<GithubUser> getUserRepositoriesNumber(@PathVariable("user") String user) {
		return counter.getGithubRepositories(user);
	}
}
