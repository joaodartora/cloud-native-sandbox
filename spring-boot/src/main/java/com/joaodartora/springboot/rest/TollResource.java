package com.joaodartora.springboot.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.joaodartora.springboot.exception.InsufficientPaymentException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.joaodartora.springboot.vehicles.Bike;
import com.joaodartora.springboot.vehicles.Bus;
import com.joaodartora.springboot.vehicles.Car;
import com.joaodartora.springboot.vehicles.Motorcycle;
import com.joaodartora.springboot.vehicles.Truck;
import com.joaodartora.springboot.vehicles.Vehicle;


@Service
@ApplicationPath("toll")
public class TollResource extends Application{

	ApplicationContext context;

	public TollResource(ApplicationContext context) {
		this.context = context;
	}
	
	@GET
	@Path("/prices")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getTollPrice() {
		
		Map<String, Double> priceMap = new HashMap<>();
		priceMap.put("Car", Car.getValue());
		priceMap.put("Bike", Bike.getValue());
		priceMap.put("Bus", Bus.getValue());
		priceMap.put("Motorcyle", Motorcycle.getValue());
		priceMap.put("Truck", Truck.getValue());
		priceMap.put("Truck Extra Axle", Truck.getValuePerExtraAxle());
		
		return Response.ok(priceMap).build();
	}
	
	@GET
	@Path("pay/{vehicle}/{payment}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPayment(@PathParam("vehicle") String vehicleType, @PathParam("payment") double payment)  {
		
		Vehicle vehicle = (Vehicle) context.getBean(vehicleType);
		try {
			return Response.ok().entity("Toll paid sucessfully! Change: "+vehicle.payToll(payment)).build();
		} catch (InsufficientPaymentException e) {
			return Response.status(400).entity(e.getMessage()).build();
		} catch (NumberFormatException n) {
			return Response.status(404).entity(n.getMessage()).build();
		}
	}
	
	@GET
	@Path("pay/truck/{axlesNumber}/{payment}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getTruckPayment(@PathParam("axlesNumber") int axlesNumber, @PathParam("payment") double payment) {
		
		Truck truck = (Truck) context.getBean(Truck.class);
		truck.setExtraAxleNumber(axlesNumber);
		try {
			return Response.ok().entity("Toll paid sucessfully! Change: "+truck.payToll(payment)).build();
		} catch (InsufficientPaymentException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
}
