package spring.training.service;

import spring.training.entity.Message;

public class Greeting {
	private Message message = new Message();

	public Greeting() {
	}

	public Greeting(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	// writable property "message" of type spring.training.entity.Message
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public void greet() {
		System.out.printf("%s from %s\n", message.getText(), message.getFrom());
	}

}





