package com.joaodartora.github.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodartora.github.controller.ReposCounterByUserController;

@SpringBootApplication
public class GithubApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ReposCounterByUserController.class, args);
	}
}
