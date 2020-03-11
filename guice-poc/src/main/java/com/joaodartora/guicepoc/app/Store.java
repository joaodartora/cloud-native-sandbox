package com.joaodartora.guicepoc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.inject.Singleton;
import com.joaodartora.guicepoc.model.Pet;

@Singleton
public class Store {
	
	private List<Pet> petList = new ArrayList<>();
	
	public void addPet(Pet pet) {
		petList.add(pet);
	}
	
	public void removePet(int id) {
			petList.removeIf(e -> e.getId() == id);
	}
	
	public Optional<Pet> searchPetById(int id){
		Optional<Pet> pet = Optional.empty();
		return pet = petList.stream().filter(p -> p.getId() == id).findFirst();
	}
		
	public List<Pet> searchPetByAge(String age) {
		List<Pet> petAgeList = new ArrayList<Pet>();
		return petAgeList = petList.stream().filter(pl -> pl.getAge().equals(age)).collect(Collectors.toList());
	}

	public List<Pet> getPetList() {
		return petList;
	}
	
}
