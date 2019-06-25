package com.at.loginapp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.at.loginapp.model.Role;
import com.at.loginapp.model.User;
import com.at.loginapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(passwordEncoder.encode(user.getPasswordConfirm()));
		user.setRoles(Arrays.asList(roleService.getRole("USER")));
		roleService.saveUserRole("USER", user);				
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
