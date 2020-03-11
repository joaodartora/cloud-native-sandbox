package com.joaodartora.springboot.spring;

import java.util.Arrays;

import javax.ws.rs.ext.RuntimeDelegate;

import com.joaodartora.springboot.vehicles.Motorcycle;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.joaodartora.springboot.rest.TollResource;
import com.joaodartora.springboot.vehicles.Bike;
import com.joaodartora.springboot.vehicles.Bus;
import com.joaodartora.springboot.vehicles.Car;
import com.joaodartora.springboot.vehicles.Truck;
import com.joaodartora.springboot.vehicles.Vehicle;

@Configuration
public class AppConfig {
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean
	@DependsOn("cxf")
	public Server jaxRsServer(ApplicationContext context) {
		final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(tollResourceService(context), JAXRSServerFactoryBean.class);
		factory.setServiceBeans(Arrays.asList(tollResourceService(context)));
		factory.setProvider(json());
		return factory.create();
	}
	
	@Bean
	public Vehicle bus() {
		return new Bus();
	}
	
	@Bean
	public Vehicle bike() {
		return new Bike();
	}
	
	@Bean
	public Vehicle motorcycle() {
		return new Motorcycle();
	}
	
	@Bean 
	public Vehicle car() {
		return new Car();
	}
	
	@Bean
	public Vehicle truck() {
		return new Truck();
	}
	
	@Bean
	public JacksonJsonProvider json() {
		return new JacksonJsonProvider();
	}
	
	@Bean
	public TollResource tollResourceService(ApplicationContext context) {
		return new TollResource(context);
	}
	
}
