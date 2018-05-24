package spring.training.service.impl;

import spring.training.service.HelloService;

public class SpanishHelloService implements HelloService {

	public SpanishHelloService() {
		System.out.println("SpanishHelloService instantiated!");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("Hola, %s!\n", name);
	}

}
