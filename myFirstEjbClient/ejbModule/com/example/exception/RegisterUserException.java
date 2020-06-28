package com.example.exception;

import javax.ejb.EJBException;

public class RegisterUserException extends EJBException {

	private static final long serialVersionUID = -6675774710415064895L;

	private String message;

	public RegisterUserException(String message) {
		super(message);
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
