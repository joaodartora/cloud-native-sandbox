package com.joaodartora.springcore.tests;

import static org.junit.Assert.*;

import com.joaodartora.springcore.calculator.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.joaodartora.springcore.calculator.Calculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ApplicationTest {

	private ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	private Calculator calculator;
	
    @Before
    public void createCalculatorBeforeTest() {
    	calculator = new Calculator(context);
    }
    
	@Test
	public void sumTest() {
		Double result = 13.0;
		assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("+", 5D, 8D));
	}
	
	@Test
	public void sumNegativeTest() {
		Double result = -13.0;
		assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("+", -5D, -8D));
	}
	
	@Test
	public void sumNegativeOnPositiveTest() {
		Double result = -1.0;
		assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("+", -5D, 4D));
	}
	
	@Test
	public void subtractTest() {
		Double result = 8.0;
		assertEquals("An error occurred in the subtract operation", result, calculator.executeOperation("-", 15D, 7D));
	}
	
	@Test
	public void subtractNegativeTest() {
		Double result = 6.0;
		assertEquals("An error occurred in the subtract operation", result, calculator.executeOperation("-", -1D, -7D));
	}
	
	@Test
	public void multiplicationTest() {
		Double result = 30.0;
		assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("*", 5D, 6D));
	}
	
	@Test
	public void multiplicationNegativeAndNegativeTest() {
		Double result = 28.0;
		assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("*", -4D, -7D));
	}
	
	@Test
	public void multiplicationNegativeAndPositiveTest() {
		Double result = -64.0;
		assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("*", 8D, -8D));
	}
	
	@Test
	public void divisionTest() {
		Double result = 4.0;
		assertEquals("An error occurred in the division operation", result, calculator.executeOperation("/", 28D, 7D));
	}
	
	@Test (expected = ArithmeticException.class)
	public void divisionByZeroTest() {
		calculator.executeOperation("/", 5D, 0D);
	}
	
	@Test
	public void exponentiationTest() {
		Double result = 64.0;
		assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("^", 2D, 6D));
	}
	
	@Test
	public void exponentiationInZeroPowerTest() {
		Double result = 1.0;
		assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("^", 2D, 0D));
	}
	
	@Test
	public void exponentiationInOnePowerTest() {
		Double result = 3.0;
		assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("^", 3D, 1D));
	}
	
	@Test
	public void exponentiationOfOneInAnyPowerTest() {
		Double result = 1.0;
		assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("^", 1D, 27D));
	}
	
	@Test
	public void exponentiationOfZeroInAnyPowerTest() {
		Double result = 0.0;
		assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("^", 0D, 90D));
	}
	
	@Test
	public void calculatorHistoricTest() {
		
		calculator.executeOperation("+", 7D, 10D);
		calculator.executeOperation("+", 80D, 9D);
		calculator.executeOperation("-", 7D, 10D);
		calculator.executeOperation("-", 20D, 17D);
		calculator.executeOperation("*", 2D, 50D);
		calculator.executeOperation("*", 9D, 4D);
		calculator.executeOperation("/", 14D, 7D);
		calculator.executeOperation("/", 81D, 9D);
		calculator.executeOperation("^", 5D, 0D);
		calculator.executeOperation("^", 10D, 2D);
		
		assertEquals("An error occurred in the sum operation", 17D, calculator.getCalculatorHistory().get(0).calculate(),0);
		assertEquals("An error occurred in the sum operation", 89D, calculator.getCalculatorHistory().get(1).calculate(),0);
		assertEquals("An error occurred in the subtract operation", -3D, calculator.getCalculatorHistory().get(2).calculate(),0);
		assertEquals("An error occurred in the subtract operation", 3D, calculator.getCalculatorHistory().get(3).calculate(),0);
		assertEquals("An error occurred in the multiply operation", 100D, calculator.getCalculatorHistory().get(4).calculate(),0);
		assertEquals("An error occurred in the multiply operation", 36D, calculator.getCalculatorHistory().get(5).calculate(),0);
		assertEquals("An error occurred in the division operation", 2D, calculator.getCalculatorHistory().get(6).calculate(),0);
		assertEquals("An error occurred in the division operation", 9D, calculator.getCalculatorHistory().get(7).calculate(),0);
		assertEquals("An error occurred in the exponentiation operation", 1D, calculator.getCalculatorHistory().get(8).calculate(),0);
		assertEquals("An error occurred in the exponentiation operation", 100D, calculator.getCalculatorHistory().get(9).calculate(),0);
		
	}
}
