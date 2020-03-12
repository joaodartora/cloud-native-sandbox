package com.joaodartora.dockerspring.operations;

public class Division implements MathOperation {
	
	private Double x;
	private Double y;
	
	public Division(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double calculate() {
		if(y == 0) {
			throw new ArithmeticException("O valor não pode ser divido por zero");
		}
		return x/y;
	}
	
	public String toString() {
		return "Division - X: " + x + " - Y: " + y + " - Result: "+(x/y)+"\n";
	}
}
