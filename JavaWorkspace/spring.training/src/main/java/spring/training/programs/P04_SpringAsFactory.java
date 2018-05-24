package spring.training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.training.service.HelloService;

public class P04_SpringAsFactory {

	public static void main(String[] args) {

		// a ref variable representing the spring container
		ApplicationContext ctx;

		// an object representing spsring container can br realized using
		// one of these classes:
		// 1. ClassPathXmlApplicationContext
		// 2. FileSystemXmlApplicationContext
		// 3. AnnotationConfigApplicationContext
		ctx = new ClassPathXmlApplicationContext("beans.xml");

		System.out.println("Pass1 -----");

		HelloService service = ctx.getBean("khs", HelloService.class);
		service.sayHello("Vinod");
		System.out.println("Pass2 -----");

		service = ctx.getBean("shs", HelloService.class);
		service.sayHello("Shyam");
		System.out.println("Pass3 -----");

		service = ctx.getBean("shs", HelloService.class);
		service.sayHello("Harish");
		
		
		((AbstractApplicationContext) ctx).close();

	}
}
