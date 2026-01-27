package org.ncu.calculator_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CalculatorAppApplication implements CommandLineRunner{
	
	private Calculator calculator;
	
	public CalculatorAppApplication(Calculator calc) {
		this.calculator = calc;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CalculatorAppApplication.class, args);
//		Calculator calc = ctx.getBean(Calculator.class);
//		calc.compute("add", 10,20);
	}

	@Override
	public void run(String... args) throws Exception {
		calculator.compute("div", 10, 20);
	}

}
