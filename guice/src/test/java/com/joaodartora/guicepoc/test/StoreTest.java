package com.joaodartora.guicepoc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.joaodartora.guicepoc.model.Pet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.joaodartora.guicepoc.app.Store;

@RunWith(MockitoJUnitRunner.class)
public class StoreTest {

	@Mock
	private Store store;
	
	@InjectMocks
	private Pet pet;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
    	store = new Store();
    	pet = new Pet();
    }
	
	@Test
	public void testAddPet() {
		store.addPet(pet);
		assertFalse("Error adding the pet!", store.getPetList().isEmpty());
	}

	@Test
	public void testRemovePet() {
		store.addPet(pet);
		int petId = pet.getId();
		store.removePet(petId);
		assertTrue("Error removing the pet!", store.getPetList().isEmpty());
	}

	@Test
	public void testSearchPetById() {
		store.addPet(pet);
		assertEquals("Error searching the pet by ID!", pet, store.searchPetById(pet.getId()).get());
	}

	@Test
	public void testSearchPetByAge() {
		List<Pet> petList = new ArrayList<Pet>();
		store.addPet(pet);
		pet.setAge("31");
		store.addPet(pet);
		pet.setAge("31");
		petList = store.searchPetByAge("31");
		assertEquals("Error searching the pets by age!", 2, petList.size());
	}
}
