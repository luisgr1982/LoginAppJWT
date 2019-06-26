package com.at.loginapp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.at.loginapp.dto.UserLoginDTO;
import com.at.loginapp.exceptions.LoginErrorException;
import com.at.loginapp.model.User;
import com.at.loginapp.repository.UserRepository;
import com.at.loginapp.security.JwtTokenProvider;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(passwordEncoder.encode(user.getPasswordConfirm()));
		user.setRoles(Arrays.asList(roleService.getRole("ROLE_USER")));
		roleService.saveUserRole("ROLE_USER", user);				
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
	
	@Override
	public UserLoginDTO loginUser(String username,String password) throws LoginErrorException {
		if (!existUser(username,password)) throw new LoginErrorException();
		final UserLoginDTO userLogin = new UserLoginDTO();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		userLogin.setToken(tokenProvider.createToken(username, userRepository.findByUsername(username).getRoles()));
		return userLogin;
	}
	
	@Override
	public Boolean existUser(String username, String password) {			
		final User user = userRepository.findByUsername(username);
		if (passwordEncoder.matches(password, user.getPassword())) return true;
		
		return false;
	}
}
