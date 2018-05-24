package spring.training.service.impl;

import spring.training.service.HelloService;

public class KannadaHelloService implements HelloService {
	
	public KannadaHelloService() {
		System.out.println("KannadaHelloService instantiated!");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("ಹಲೋ, %s!\n", name);
	}

}
