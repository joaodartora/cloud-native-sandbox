package com.joaodartora.twitter.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterInstantiator {

	@Value("${CONSUMER_KEY}")
	private String consumerKey;

	@Value("${CONSUMER_SECRET}")
	private String consumerSecret;

	@Value("${ACCESS_TOKEN}")
	private String accessToken;

	@Value("${ACCESS_SECRET}")
	private String accessSecret;
	
	public Twitter getTwitterInstance () {
		
		TwitterFactory factory = new TwitterFactory(new ConfigurationBuilder().setDebugEnabled(true)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessSecret).build());
		
		return factory.getInstance();
	}
	
}
