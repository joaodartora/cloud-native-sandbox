package com.joaodartora.springboot.vehicles;

import com.joaodartora.springboot.exception.InsufficientPaymentException;

public interface Vehicle {

	double payToll(double amountPaid) throws InsufficientPaymentException;
	
}
