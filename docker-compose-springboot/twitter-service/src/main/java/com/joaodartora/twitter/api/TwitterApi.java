package com.joaodartora.twitter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.joaodartora.twitter.model.TwitterUser;

import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
@ComponentScan(basePackages = "com.joaodartora.twitter")
public class TwitterApi {

	@Autowired
	TwitterInstantiator instantiator;
		
	public ResponseEntity getTweetsNumber(String user){
		
		Twitter twitter = instantiator.getTwitterInstance();  
		
		try {
			return new ResponseEntity<TwitterUser>(new TwitterUser(user, twitter.showUser(user).getStatusesCount()), HttpStatus.OK);
		} catch (TwitterException exception) {
			return new ResponseEntity<Exception>(exception, HttpStatus.NOT_FOUND);
		}
	}
		
}
