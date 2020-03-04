package com.joaodartora.springcore.operations;

public class Sum implements MathOperation {

	private Double x;
	private Double y;
	
	public Sum(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double calculate() {
		return x+y;
	}

	public String toString() {
		return "Sum - X: " + x + " - Y: " + y + " - Result: "+(x+y)+"\n";
	}

}
