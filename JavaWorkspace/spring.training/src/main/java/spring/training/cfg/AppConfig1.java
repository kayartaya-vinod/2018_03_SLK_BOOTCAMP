package spring.training.cfg;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.entity.Message;
import spring.training.service.Greeting;

// @Configuration denotes that this class is a configuration class, equivalent of beans.xml
@Configuration
public class AppConfig1 {

	public AppConfig1() {
		System.out.println("AppConfig1 instantiated!");
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public Greeting gr1() {
		System.out.println("Returning an instanceof Greeting class..");
		Greeting g = new Greeting();
		// call to the msg() function is only to get an instance of Message class,
		// and spring caches the object and subsequent calls to the same function,
		// will only get the cached object (singleton)
		// g.setMessage(msg()); // manual wiring

		return g;
	}

	@Bean
	public Message msg() {
		System.out.println("Returning an instnaceof Message class..");
		return new Message("Hello Spring", "Vinod");
	}
}
