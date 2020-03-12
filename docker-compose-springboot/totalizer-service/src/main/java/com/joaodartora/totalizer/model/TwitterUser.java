package com.joaodartora.totalizer.model;

public class TwitterUser {

	private String username;
	private Integer tweets;
	
	public TwitterUser(String username, Integer tweets) {
		this.username = username;
		this.tweets = tweets;
	}
	
	public TwitterUser() {}

	public String getUsername() {
		return username;
	}

	public Integer getTweets() {
		return tweets;
	}

}
