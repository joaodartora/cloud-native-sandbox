package com.joaodartora.guicepoc.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.joaodartora.guicepoc.model.Pet;
import com.joaodartora.guicepoc.services.Service;

@Singleton
public class History {

	private final int EXPENSIVE_PETS_LIST_SIZE = 10;
	
	@Inject
	private static List<Service> servicesList = new ArrayList<Service>();
	
	public static void addServiceToHistory(Service service) {
		servicesList.add(service);
	}
	
	public List<Service> getServicesHistory(){
		return Collections.unmodifiableList(servicesList);
	}
	
	public List<Pet> getMostExpensivePets(List<Pet> petList) {
		List<Pet> expensivePetsList = petList;
		Collections.sort(expensivePetsList, new Comparator<Pet>() {
			public int compare(Pet p1, Pet p2) {
				return (p2.getAmountSpent() - p1.getAmountSpent());
			}
		});
		return (expensivePetsList.size() < EXPENSIVE_PETS_LIST_SIZE) ? expensivePetsList : expensivePetsList.subList(0, EXPENSIVE_PETS_LIST_SIZE);
	}
}