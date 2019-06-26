package com.at.loginapp.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.loginapp.dto.UserDTO;
import com.at.loginapp.dto.UserLoginDTO;
import com.at.loginapp.exceptions.EmailLoginExistException;
import com.at.loginapp.exceptions.LoginErrorException;
import com.at.loginapp.exceptions.UserLoginExistException;
import com.at.loginapp.services.UserService;
import com.at.loginapp.utils.UserMapperServiceImpl;

import static com.at.loginapp.utils.Constants.REGISTER_URL;
import static com.at.loginapp.utils.Constants.LOGIN_URL;
import static com.at.loginapp.utils.Constants.LOGOUT_URL;
import static com.at.loginapp.utils.Constants.HOME_URL;
import static com.at.loginapp.utils.Constants.USERCONTROLLER_URL;

@RestController
@RequestMapping(USERCONTROLLER_URL)
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapperServiceImpl mapper;

	@PostMapping(REGISTER_URL)
	public ResponseEntity<?> registrationUserAccount(@Valid @RequestBody UserDTO userDTO)
			throws UserLoginExistException, EmailLoginExistException {
		if (Optional.ofNullable(userService.findByUsername(userDTO.getUsername())).isPresent())
			throw new UserLoginExistException();
		if (Optional.ofNullable(userService.findByEmail(userDTO.getEmail())).isPresent())
			throw new EmailLoginExistException();
		userService.saveUser(mapper.mapToEntity(userDTO));
		return ResponseEntity.ok().build();
	}

	@PostMapping(LOGIN_URL)
	public ResponseEntity<UserLoginDTO> loginUserAccount(@RequestParam("username") String username,
			@RequestParam("password") String password) throws LoginErrorException {
		return new ResponseEntity<UserLoginDTO>(userService.loginUser(username, password), HttpStatus.OK);
	}

	@GetMapping(LOGOUT_URL)
	public String logoutUserAccount(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth.isAuthenticated()){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }
	        return "Logout";
	}
	
	@GetMapping(HOME_URL)
	public String welcome() {
		return "Bienvenidos";
	}
}
