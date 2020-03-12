package com.joaodartora.twitter.model;

public class TwitterUser {

	private String username;
	private Integer tweets;
	
	public TwitterUser(String username, Integer tweets) {
		this.username = username;
		this.tweets = tweets;
	}

	public String getUsername() {
		return username;
	}

	public Integer getTweets() {
		return tweets;
	}
	
}
