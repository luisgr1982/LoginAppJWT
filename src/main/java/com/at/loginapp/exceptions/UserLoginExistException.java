package com.at.loginapp.exceptions;

public class UserLoginExistException extends Exception{
	
	/**
	 * Excepcion que salta al intentar guardar un usuario que ya existe.
	 */
	private static final long serialVersionUID = 609965172860035842L;
	public static final String MESSAGE = "El usuario introducido ya se encuentra dado de alta.";
	
	public UserLoginExistException() {
		super (MESSAGE);		
	}
}
