package com.joaodartora.springcore.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	private static Calculator calculator = (Calculator) context.getBean("calculator");
	
	public static void main(String[] args) {
		
		System.out.println(calculator.executeOperation("+", 8D, 5D));
		System.out.println(calculator.executeOperation("-", 17D, 7D));
		System.out.println(calculator.executeOperation("/", 21D, 7D));
		System.out.println(calculator.executeOperation("*", 5D, 6D));
		System.out.println(calculator.executeOperation("^", 2D, 5D));
		System.out.println(calculator.getCalculatorHistory());
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
