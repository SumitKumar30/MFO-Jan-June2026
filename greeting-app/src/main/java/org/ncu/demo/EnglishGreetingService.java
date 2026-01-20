package org.ncu.demo;

import org.springframework.stereotype.Component;

@Component
public class EnglishGreetingService implements GreetingService {

	@Override
	public void greet(String name) {
		System.out.println("Hello "+name);
	}

}
