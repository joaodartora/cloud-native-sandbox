package com.joaodartora.springboot.vehicles;

import com.joaodartora.springboot.exception.InsufficientPaymentException;

public class Car implements Vehicle {

	private static final double VALUE = 2.11;
	
	public double payToll(double amountPaid) throws InsufficientPaymentException {
		if (amountPaid < VALUE) {
			throw new InsufficientPaymentException("Payment below the minimum, required further $"+(VALUE-amountPaid));
		}
		return amountPaid - VALUE;
	}

	public static double getValue() {
		return VALUE;
	}

}
