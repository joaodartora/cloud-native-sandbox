package com.joaodartora.totalizer.controller;

import javax.ws.rs.Produces;

import com.joaodartora.totalizer.model.TotalizerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joaodartora.totalizer.callers.GithubRequest;
import com.joaodartora.totalizer.callers.TwitterRequest;


@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.joaodartora.totalizer")
public class TotalizerController {
	
	@Autowired
	private GithubRequest githubRequest;
	
	@Autowired
	private TwitterRequest twitterRequest;
	
	@RequestMapping(value="totalizer/twitter/{twitterUser}/github/{gitUser}", method = RequestMethod.GET)
    @Produces("application/json")
	public ResponseEntity <TotalizerResponse> getTwitterAndGithubData(@PathVariable("twitterUser") String twitterUser, @PathVariable("gitUser") String gitUser) {
	        return new ResponseEntity<TotalizerResponse>(
	        		new TotalizerResponse(githubRequest.getGithubUser(gitUser), twitterRequest.getTwitterUser(twitterUser)), HttpStatus.OK);
	}
}
