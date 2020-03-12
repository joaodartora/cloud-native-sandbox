package com.joaodartora.totalizer.model;

public class TotalizerResponse {

	private GithubUser github;
	private TwitterUser twittter;
	
	public TotalizerResponse(GithubUser receivedGithub, TwitterUser receivedTwittter) {
		this.github = receivedGithub;
		this.twittter = receivedTwittter;
	}
	
	public TotalizerResponse() {}

	public GithubUser getGithub() {
		return github;
	}

	public void setGithub(GithubUser github) {
		this.github = github;
	}

	public TwitterUser getTwittter() {
		return twittter;
	}

	public void setTwittter(TwitterUser twittter) {
		this.twittter = twittter;
	}
	
	
	
}
