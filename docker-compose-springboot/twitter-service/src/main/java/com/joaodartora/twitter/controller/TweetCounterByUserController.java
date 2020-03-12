package com.joaodartora.twitter.controller;

import javax.ws.rs.Produces;

import com.joaodartora.twitter.api.TwitterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joaodartora.twitter.model.TwitterUser;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.joaodartora.twitter")
public class TweetCounterByUserController {
	
	@Autowired
	private TwitterApi counter;
	
	@RequestMapping(value="/twitter/{user}", method = RequestMethod.GET)
	@Produces("application/json")
	public ResponseEntity<TwitterUser> getUserTweetNumber(@PathVariable("user") String user) {
		return counter.getTweetsNumber(user);
	}
	
}
