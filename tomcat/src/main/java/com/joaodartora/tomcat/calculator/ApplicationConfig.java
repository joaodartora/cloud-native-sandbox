package com.joaodartora.tomcat.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.joaodartora.tomcat.operations.Division;
import com.joaodartora.tomcat.operations.Exponentiation;
import com.joaodartora.tomcat.operations.MathOperation;
import com.joaodartora.tomcat.operations.Multiplication;
import com.joaodartora.tomcat.operations.Subtraction;
import com.joaodartora.tomcat.operations.Sum;

@Configuration
@ComponentScan(basePackages = "com.joaodartora.cloudnative.tema1")
public class ApplicationConfig {
	
	@Bean
	public Calculator calculator(ApplicationContext applicationContext) {
		return new Calculator(applicationContext);
	}
	
	@Bean(name="SUM")
	@Scope("prototype")
	public MathOperation addValues(Double x, Double y) {
		return new Sum(x,y);
	}

	@Bean(name="SUB")
	@Scope("prototype")
	public MathOperation subtractValues(Double x, Double y) {
		return new Subtraction(x,y);
	}
	
	@Bean(name="DIV")
	@Scope("prototype")
	public MathOperation divideValues(Double x, Double y) {
		return new Division(x,y);
	}
	
	@Bean(name="MULTI")
	@Scope("prototype")
	public MathOperation multiplyValues(Double x, Double y) {
		return new Multiplication(x,y);
	}
	
	@Bean(name="POW")
	@Scope("prototype")
	public MathOperation raiseXOnYPower(Double x, Double y) {
		return new Exponentiation(x,y);
	}
}
