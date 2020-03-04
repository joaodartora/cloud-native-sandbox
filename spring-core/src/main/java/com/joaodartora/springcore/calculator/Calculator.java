package com.joaodartora.springcore.calculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.context.ApplicationContext;
import com.joaodartora.springcore.operations.MathOperation;

public class Calculator {
	
		private ApplicationContext context;
		private List<MathOperation> calculatorHistory = new ArrayList<>();
		
		public Calculator(ApplicationContext context) {
			this.context = context;
		}
		
		public Double executeOperation(String operation, Double x, Double y) {
			MathOperation mathOperation = (MathOperation) context.getBean(operation,x,y);
			calculatorHistory.add(mathOperation);
			return mathOperation.calculate();
		}
		
		public List<MathOperation> getCalculatorHistory() {
			return Collections.unmodifiableList(calculatorHistory);
		}
}
