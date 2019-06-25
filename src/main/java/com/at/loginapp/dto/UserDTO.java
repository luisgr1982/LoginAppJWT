package com.at.loginapp.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.at.loginapp.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserDTO {
	private Long id;
	
	@NotEmpty
	@NotNull
	private String username;
	
	@NotEmpty
	@NotNull	
	private String password;
	
	@NotEmpty
	@NotNull
	private String passwordConfirm;
	
	@Email
	private String email;
	
	private List<Role> roles;
}
