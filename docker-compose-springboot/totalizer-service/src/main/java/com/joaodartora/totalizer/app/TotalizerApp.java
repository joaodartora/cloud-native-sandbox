package com.joaodartora.totalizer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodartora.totalizer.controller.TotalizerController;

@SpringBootApplication
public class TotalizerApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TotalizerController.class, args);
	}
}