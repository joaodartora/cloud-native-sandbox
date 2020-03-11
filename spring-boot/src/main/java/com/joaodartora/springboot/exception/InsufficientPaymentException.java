package com.joaodartora.springboot.exception;

public class InsufficientPaymentException extends Exception {

	private static final long serialVersionUID = -8061548022157796805L;

	public InsufficientPaymentException(String errorMessage) {
		super(errorMessage);
	}
	
	public InsufficientPaymentException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
	
}
