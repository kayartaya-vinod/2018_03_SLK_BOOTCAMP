package spring.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.training.service.Greeting;

public class P05_SpringWiring {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("beans2.xml");

		
		Greeting gr = ctx.getBean(Greeting.class);
		gr.greet();
		
		ctx.close();
	}
}






