package com.at.loginapp.services;

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
}
