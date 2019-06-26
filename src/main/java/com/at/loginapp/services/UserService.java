package com.at.loginapp.services;

import com.at.loginapp.dto.UserLoginDTO;
import com.at.loginapp.exceptions.LoginErrorException;
import com.at.loginapp.model.User;

public interface UserService {
	/**
	 * 
	 * @param user
	 */
	public User saveUser(User user);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	/**
	 * @throws LoginErrorException 
	 * 
	 */
	public UserLoginDTO loginUser(String username, String password) throws LoginErrorException;
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	Boolean existUser(String username, String password);

}
