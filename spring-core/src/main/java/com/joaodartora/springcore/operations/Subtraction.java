package com.joaodartora.springcore.operations;

public class Subtraction implements MathOperation{
	
	private Double x;
	private Double y;
	
	public Subtraction(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double calculate() {
		return x-y;
	}
	
	public String toString() {
		return "Subtraction - X: " + x + " - Y: " + y + " - Result: "+(x-y)+"\n";
	}
}
