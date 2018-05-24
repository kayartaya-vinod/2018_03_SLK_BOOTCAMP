package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig1;
import spring.training.service.Greeting;

public class P06_AnnotationConfigDemo {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
		
		Greeting g = ctx.getBean(Greeting.class);
		g.greet();
		
		ctx.close();
		System.out.println("End of main!");
	}

}
