package com.joaodartora.guicepoc.services;

import com.google.inject.Inject;
import com.joaodartora.guicepoc.app.History;
import com.joaodartora.guicepoc.model.Pet;

public class Bath implements Service{

	private static final int DRY_BATH_PRICE = 50;
	private static final int WATER_BATH_PRICE = 30;
	private static final int PERFUME_PRICE = 15;
	
	private Pet pet;
	private String type;

	@Inject
	public Bath(Pet pet, String type) {
		this.pet = pet;
		this.type = type;
	}
	
	public Bath() {}

	public void doDryBathPerfumed(Pet pet) {
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += (DRY_BATH_PRICE + PERFUME_PRICE);
		pet.setAmountSpent(newAmountSpent);
		registerService(new Bath(pet, "DryPerfumed"));
	}
	
	public void doDryBathWithoutPerfume(Pet pet) {
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += DRY_BATH_PRICE;
		pet.setAmountSpent(newAmountSpent);
		registerService(new Bath(pet, "DryWhitoutPerfume"));
	}
	
	public void doWaterBathPerfumed(Pet pet){
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += (WATER_BATH_PRICE + PERFUME_PRICE);
		pet.setAmountSpent(newAmountSpent);
		registerService(new Bath(pet, "WaterPerfumed"));
	}
	
	public void doWaterBathWithoutPerfume(Pet pet) {
		int newAmountSpent = pet.getAmountSpent();
		newAmountSpent += WATER_BATH_PRICE;
		pet.setAmountSpent(newAmountSpent);
		registerService(new Bath(pet, "WaterWhitoutPerfume"));
	}

	public String toString() {
		return "Bath - Pet: " + pet + " - Type: " + type;
	}

	public void registerService(Service service) {
		History.addServiceToHistory(service);
	}
}
