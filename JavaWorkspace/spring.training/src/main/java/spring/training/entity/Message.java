package spring.training.entity;

public class Message {

	private String text;
	private String from;

	public Message() {
	}

	public Message(String text, String from) {
		this.text = text;
		this.from = from;
	}

	public String getText() {
		return text;
	}

	// writable property "text" (mutator)
	// spring can invoke this function to set the value of the property
	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	// writable property "from" 
	public void setFrom(String from) {
		this.from = from;
	}

}
