package com.joaodartora.guicepoc.model;

import java.util.Random;

import com.google.inject.Inject;

public class Pet {

	private int id;
	private String name;
	private String race;
	private String age;
	private int amountSpent;

	@Inject
	public Pet(String name, String race, String age) {
		this.id = generateId();
		this.name = name;
		this.race = race;
		this.age = age;
		this.amountSpent = 0;
	}

	public Pet() {}

	public int getId() {
		return id;
	}

	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public int getAmountSpent() {
		return amountSpent;
	}
	
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}

	public int generateId() {
		return new Random().nextInt(1000);
	}

	public String toString() {
		return "Pet - ID: " + id + " - Name: " + name + " - Race: " + race + " - Age: " + age + " - AmountSpent: " + amountSpent;
	}
}
