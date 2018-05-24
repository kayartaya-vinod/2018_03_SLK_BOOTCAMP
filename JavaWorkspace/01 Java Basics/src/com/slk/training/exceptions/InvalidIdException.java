package com.slk.training.exceptions;

public class InvalidIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidIdException() {
		super("Invalid Id!");
	}

	public InvalidIdException(String message) {
		super(message);
	}

	public InvalidIdException(Throwable cause) {
		super(cause);
	}

}
