package org.ncu.calculator_app;

import org.springframework.stereotype.Component;

@Component
public class DivisionService implements MathService {

	@Override
	public void operate(int x, int y) {
		System.out.println("Division: "+(x/y));
	}

}
