package com.joaodartora.guicepoc.test;

import static org.junit.Assert.*;

import com.joaodartora.guicepoc.model.Pet;
import com.joaodartora.guicepoc.services.Bath;
import com.joaodartora.guicepoc.services.Haircut;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.joaodartora.guicepoc.app.History;
import com.joaodartora.guicepoc.app.Store;

@RunWith(MockitoJUnitRunner.class)
public class HistoryTest {

	@Mock
	private History history;
	
	@InjectMocks
	private Store store;
	private Pet pet;
	private Bath bath;
	private Haircut haircut;
	
	@Before
	public void createHistoryBeforeTest() {
		MockitoAnnotations.initMocks(this);
		history = new History();
		store = new Store();
		pet = new Pet();
		bath = new Bath();
		haircut = new Haircut();
    }
	
	@Test
	public void testAddServiceToHistory() {
		History.addServiceToHistory(new Bath(pet, "DryPerfumed"));
		assertFalse("Error adding the service!", history.getServicesHistory().isEmpty());
	}

	@Test
	public void testGetServicesHistory() {
		History.addServiceToHistory(new Haircut(pet, "Long"));
		History.addServiceToHistory(new Bath(pet, "WaterWhitoutPerfume"));
		History.addServiceToHistory(new Haircut(pet, "Short"));
		assertEquals("Error getting the services history!", 9, history.getServicesHistory().size());
	}

	@Test
	public void testGetMostExpensivePets() {
		store.addPet(new Pet("gesonel", "duck", "32"));
		store.addPet(new Pet("darth", "dog", "77"));
		haircut.doLongHaircut(store.getPetList().get(0));
		bath.doWaterBathWithoutPerfume(store.getPetList().get(1));
		assertEquals("Error on the most expensive pets list", 30, history.getMostExpensivePets(store.getPetList()).get(0).getAmountSpent());
	}

}
