package org.ncu.calculator_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	private MathService additionService;
	private MathService subtractionService;
	private MathService multiplicationService;
	private MathService divisionService;
	
	public Calculator(MathService additionService, MathService subtractionService, MathService multiplicationService,
			MathService divisionService) {
		this.additionService = additionService;
		this.subtractionService = subtractionService;
		this.multiplicationService = multiplicationService;
		this.divisionService = divisionService;
	}
	
	public void compute(String operation, int x, int y) {
		if(operation == "add")
			additionService.operate(x, y);
		else if(operation == "sub")
				subtractionService.operate(x, y);
		else if(operation == "mul")
				multiplicationService.operate(x, y);
		else if(operation == "div")
				divisionService.operate(x, y);
		else {
			//System.err.println("Error! Invalid Operation!!!");
			throw new RuntimeException("Invalid Operation!!!!");
		}
	}
}
