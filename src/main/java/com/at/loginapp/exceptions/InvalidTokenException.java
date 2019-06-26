package com.at.loginapp.exceptions;

public class InvalidTokenException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8591800671039420747L;
	private static final String MESSAGE = "TOKEN INVALIDO O EXPIRADO";
	
	public InvalidTokenException() {
		super(MESSAGE);
	}
}
