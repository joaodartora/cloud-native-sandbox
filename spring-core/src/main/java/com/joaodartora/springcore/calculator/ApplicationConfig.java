package com.joaodartora.springcore.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.joaodartora.springcore.operations.Division;
import com.joaodartora.springcore.operations.Exponentiation;
import com.joaodartora.springcore.operations.MathOperation;
import com.joaodartora.springcore.operations.Multiplication;
import com.joaodartora.springcore.operations.Subtraction;
import com.joaodartora.springcore.operations.Sum;

@Configuration
@ComponentScan(basePackages = "com.joaodartora.springcore.calculator")
public class ApplicationConfig {
	
	@Bean
	public Calculator calculator(ApplicationContext applicationContext) {
		return new Calculator(applicationContext);
	}
	
	@Bean(name="+")
	@Scope("prototype")
	public MathOperation addValues(Double x, Double y) {
		return new Sum(x,y);
	}

	@Bean(name="-")
	@Scope("prototype")
	public MathOperation subtractValues(Double x, Double y) {
		return new Subtraction(x,y);
	}
	
	@Bean(name="/")
	@Scope("prototype")
	public MathOperation divideValues(Double x, Double y) {
		return new Division(x,y);
	}
	
	@Bean(name="*")
	@Scope("prototype")
	public MathOperation multiplyValues(Double x, Double y) {
		return new Multiplication(x,y);
	}
	
	@Bean(name="^")
	@Scope("prototype")
	public MathOperation raiseXOnYPower(Double x, Double y) {
		return new Exponentiation(x,y);
	}
}
