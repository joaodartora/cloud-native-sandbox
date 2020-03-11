package com.joaodartora.springboot.vehicles;

import com.joaodartora.springboot.exception.InsufficientPaymentException;

public class Truck implements Vehicle {

	private static final double VALUE = 3.95;
	private static final double EXTRA_AXLE_VALUE = 1.30;
	private int extraAxleNumber = 0;
	
	public double payToll(double amountPaid) throws InsufficientPaymentException {
		if (amountPaid < (VALUE+(EXTRA_AXLE_VALUE*extraAxleNumber))) {
			throw new InsufficientPaymentException("Payment below the minimum, required further $"+((VALUE+(EXTRA_AXLE_VALUE*extraAxleNumber))-amountPaid));
		}
		return amountPaid - (EXTRA_AXLE_VALUE*extraAxleNumber) - VALUE;
	}

	public static double getValue() {
		return VALUE;
	}
	
	public static double getValuePerExtraAxle() {
		return EXTRA_AXLE_VALUE;
	}
	
	public double getTotalValue() {
		return VALUE*extraAxleNumber;
	}

	public void setExtraAxleNumber(int extraAxleNumber) {
		this.extraAxleNumber = extraAxleNumber;
	}

}
