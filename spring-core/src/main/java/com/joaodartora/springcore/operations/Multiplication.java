package com.joaodartora.springcore.operations;

public class Multiplication implements MathOperation{

	private Double x;
	private Double y;
	
	public Multiplication(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double calculate() {
		return x*y;
	}
	
	public String toString() {
		return "Multiplication - X: " + x + " - Y: " + y + " - Result: "+(x*y)+"\n";
	}
}
