package com.joaodartora.guice.test;

import static org.junit.Assert.*;

import com.joaodartora.guice.model.Pet;
import com.joaodartora.guice.services.Haircut;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HaircutTest {

	@Mock
	private Pet pet;
	
	@InjectMocks
	private Haircut haircut;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		pet = new Pet();
		haircut = new Haircut();
	}
	
	@Test
	public void testDoLongHaircut() {
		haircut.doLongHaircut(pet);
		assertEquals("Error on the long haircut!", 20, pet.getAmountSpent());
	}

	@Test
	public void testDoShortHaircut() {
		haircut.doShortHaircut(pet);
		assertEquals("Error on the short haircut!", 10, pet.getAmountSpent());
	}

}
