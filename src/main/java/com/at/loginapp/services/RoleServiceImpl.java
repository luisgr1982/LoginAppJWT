package com.at.loginapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.loginapp.model.Role;
import com.at.loginapp.model.User;
import com.at.loginapp.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getRole(String role) {
		return roleRepository.findByName(role);
	}

	@Override
	public void saveUserRole(String role, User user) {
		this.getRole(role).getUsers().add(user);
	}

}
