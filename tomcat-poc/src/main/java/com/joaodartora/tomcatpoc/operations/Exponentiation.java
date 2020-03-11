package com.joaodartora.tomcatpoc.operations;

public class Exponentiation implements MathOperation{

	private Double x;
	private Double y;
	
	public Exponentiation(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double calculate() {
		return Math.pow(x, y);
	}
	
	public String toString() {
		return "Exponentiation - X: " + x + " - Y: " + y + " - Result: "+(Math.pow(x, y))+"\n";
	}
}
