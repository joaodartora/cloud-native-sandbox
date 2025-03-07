package com.joaodartora.springboot.vehicles;

import com.joaodartora.springboot.exception.InsufficientPaymentException;

public class Motorcycle implements Vehicle  {

	private static final double VALUE = 1.0;
	
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
