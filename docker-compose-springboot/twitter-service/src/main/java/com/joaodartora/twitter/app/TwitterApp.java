package com.joaodartora.twitter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodartora.twitter.controller.TweetCounterByUserController;

@SpringBootApplication
public class TwitterApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TweetCounterByUserController.class, args);
	}
}
