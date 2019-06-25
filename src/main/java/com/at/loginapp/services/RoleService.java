package com.at.loginapp.services;

import com.at.loginapp.model.Role;
import com.at.loginapp.model.User;

public interface RoleService {
	/**
	 * Metodo que busca un Rol
	 * 
	 * @param role
	 * @return
	 */
	public Role getRole(String role);
	
	public void saveUserRole(String role, User user);

}
