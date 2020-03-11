package com.joaodartora.guice.test;

import static org.junit.Assert.*;

import com.joaodartora.guice.model.Pet;
import com.joaodartora.guice.services.Bath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BathTest {
	
	@Mock
	private Pet pet;
	
	@InjectMocks
	private Bath bath;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		pet = new Pet();
		bath = new Bath();
	}
	
	@Test
	public void testDoDryBathPerfumed() {
		bath.doDryBathPerfumed(pet);
		assertEquals("Error on the dry bath perfumed!", 65, pet.getAmountSpent());
	}

	@Test
	public void testDoDryBathWithoutPerfume() {
		bath.doDryBathWithoutPerfume(pet);
		assertEquals("Error on the dry bath without perfume!", 50, pet.getAmountSpent());
	}

	@Test
	public void testDoWaterBathPerfumed() {
		bath.doWaterBathPerfumed(pet);
		assertEquals("Error on the water bath perfumed!", 45, pet.getAmountSpent());
	}

	@Test
	public void testDoWaterBathWithoutPerfume() {
		bath.doWaterBathWithoutPerfume(pet);
		assertEquals("Error on the dry bath without perfume!", 30, pet.getAmountSpent());
	}
}
