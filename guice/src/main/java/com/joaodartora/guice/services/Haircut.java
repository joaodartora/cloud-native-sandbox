package com.joaodartora.guice.services;

import com.google.inject.Inject;
import com.joaodartora.guice.app.History;
import com.joaodartora.guice.model.Pet;

public class Haircut implements Service{

	private static final int SHORT_CUT_PRICE = 10;
	private static final int LONG_CUT_PRICE = 20;
	
	private Pet pet;
	private String type;
	
	@Inject
	public Haircut(Pet pet, String type) {
		this.pet = pet;
		this.type = type;
	}

	public Haircut() {}

	public void doLongHaircut(Pet pet) {
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += LONG_CUT_PRICE;
		pet.setAmountSpent(newAmountSpent);
		registerService(new Haircut(pet, "Long"));
	}
	
	public void doShortHaircut(Pet pet) {
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += SHORT_CUT_PRICE;
		pet.setAmountSpent(newAmountSpent);
		registerService(new Haircut(pet, "Short"));
	}
	
	public String toString() {
		return "Haircut - Pet: " + pet + " - Type: " + type;
	}

	public void registerService(Service service) {
		History.addServiceToHistory(service);
	}
}
