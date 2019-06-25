package com.at.loginapp.exceptions;

public class LoginRegistrationErrorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Los datos del registro no son correctos.";
	
	public LoginRegistrationErrorException() {
		super(MESSAGE);
	}
	
}
