package spring.training.service.impl;

import spring.training.service.HelloService;

public class EnglishHelloService implements HelloService {
	
	public EnglishHelloService() {
		System.out.println("EnglishHelloService instantiated!");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("Hello, %s!\n", name);
	}

}
