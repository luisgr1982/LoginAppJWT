package com.at.loginapp.exceptions;

public class EmailLoginExistException extends Exception{
	
	/**
	 * Excepcion qeus salta cuando se intenta dar de alta un email que ya existe.
	 */
	private static final long serialVersionUID = 9056657976458797395L;
	public static final String MESSAGE = "El email introducido ya se encuentra dado de alta.";
	
	public EmailLoginExistException() {
		super(MESSAGE);
	}
}
