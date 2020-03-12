package com.joaodartora.github.model;

public class GithubUser {

	private String username;
	private Integer repositories;
	
	public GithubUser(String username, Integer repositories) {
		this.username = username;
		this.repositories = repositories;
	}

	public String getUsername() {
		return username;
	}

	public Integer getRepositories() {
		return repositories;
	}
}
