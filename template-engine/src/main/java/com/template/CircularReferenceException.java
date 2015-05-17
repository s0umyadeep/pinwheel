package com.template;

public class CircularReferenceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CircularReferenceException(String string) {
		super(string);
	}
}
