package com.at.loginapp.exceptions;

public class LoginErrorException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9101918117841818129L;
	private static final String MESSAGE ="Los datos del usuario no se encuentra en base de datos";
	
	public LoginErrorException() {
		super(MESSAGE);
	}

}
