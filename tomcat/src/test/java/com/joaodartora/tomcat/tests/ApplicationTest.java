package com.joaodartora.tomcat.tests;

import com.joaodartora.tomcat.calculator.ApplicationConfig;
import com.joaodartora.tomcat.calculator.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

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
        assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("SUM", 5D, 8D));
    }

    @Test
    public void sumNegativeTest() {
        Double result = -13.0;
        assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("SUM", -5D, -8D));
    }

    @Test
    public void sumNegativeOnPositiveTest() {
        Double result = -1.0;
        assertEquals("An error occurred in the sum operation", result, calculator.executeOperation("SUM", -5D, 4D));
    }

    @Test
    public void subtractTest() {
        Double result = 8.0;
        assertEquals("An error occurred in the subtract operation", result, calculator.executeOperation("SUB", 15D, 7D));
    }

    @Test
    public void subtractNegativeTest() {
        Double result = 6.0;
        assertEquals("An error occurred in the subtract operation", result, calculator.executeOperation("SUB", -1D, -7D));
    }

    @Test
    public void multiplicationTest() {
        Double result = 30.0;
        assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("MULTI", 5D, 6D));
    }

    @Test
    public void multiplicationNegativeAndNegativeTest() {
        Double result = 28.0;
        assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("MULTI", -4D, -7D));
    }

    @Test
    public void multiplicationNegativeAndPositiveTest() {
        Double result = -64.0;
        assertEquals("An error occurred in the multiply operation", result, calculator.executeOperation("MULTI", 8D, -8D));
    }

    @Test
    public void divisionTest() {
        Double result = 4.0;
        assertEquals("An error occurred in the division operation", result, calculator.executeOperation("DIV", 28D, 7D));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.executeOperation("DIV", 5D, 0D);
    }

    @Test
    public void exponentiationTest() {
        Double result = 64.0;
        assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("POW", 2D, 6D));
    }

    @Test
    public void exponentiationInZeroPowerTest() {
        Double result = 1.0;
        assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("POW", 2D, 0D));
    }

    @Test
    public void exponentiationInOnePowerTest() {
        Double result = 3.0;
        assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("POW", 3D, 1D));
    }

    @Test
    public void exponentiationOfOneInAnyPowerTest() {
        Double result = 1.0;
        assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("POW", 1D, 27D));
    }

    @Test
    public void exponentiationOfZeroInAnyPowerTest() {
        Double result = 0.0;
        assertEquals("An error occurred in the exponentiation operation", result, calculator.executeOperation("POW", 0D, 90D));
    }

    @Test
    public void calculatorHistoricTest() {

        calculator.executeOperation("SUM", 7D, 10D);
        calculator.executeOperation("SUM", 80D, 9D);
        calculator.executeOperation("SUB", 7D, 10D);
        calculator.executeOperation("SUB", 20D, 17D);
        calculator.executeOperation("MULTI", 2D, 50D);
        calculator.executeOperation("MULTI", 9D, 4D);
        calculator.executeOperation("DIV", 14D, 7D);
        calculator.executeOperation("DIV", 81D, 9D);
        calculator.executeOperation("POW", 5D, 0D);
        calculator.executeOperation("POW", 10D, 2D);

        assertEquals("An error occurred in the sum operation", 17D, calculator.getCalculatorHistory().get(0).calculate(), 0);
        assertEquals("An error occurred in the sum operation", 89D, calculator.getCalculatorHistory().get(1).calculate(), 0);
        assertEquals("An error occurred in the subtract operation", -3D, calculator.getCalculatorHistory().get(2).calculate(), 0);
        assertEquals("An error occurred in the subtract operation", 3D, calculator.getCalculatorHistory().get(3).calculate(), 0);
        assertEquals("An error occurred in the multiply operation", 100D, calculator.getCalculatorHistory().get(4).calculate(), 0);
        assertEquals("An error occurred in the multiply operation", 36D, calculator.getCalculatorHistory().get(5).calculate(), 0);
        assertEquals("An error occurred in the division operation", 2D, calculator.getCalculatorHistory().get(6).calculate(), 0);
        assertEquals("An error occurred in the division operation", 9D, calculator.getCalculatorHistory().get(7).calculate(), 0);
        assertEquals("An error occurred in the exponentiation operation", 1D, calculator.getCalculatorHistory().get(8).calculate(), 0);
        assertEquals("An error occurred in the exponentiation operation", 100D, calculator.getCalculatorHistory().get(9).calculate(), 0);

    }
}
