package com.at.loginapp.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.at.loginapp.dto.UserDTO;
import com.at.loginapp.model.User;

@Component
public class UserMapperServiceImpl implements MapperService<UserDTO, User> {

	@Override
	public UserDTO mapToDto(User user) { 
		return new ModelMapper().map(user, UserDTO.class);
	}

	@Override
	public User mapToEntity(UserDTO userDTO) {
		return new ModelMapper().map(userDTO, User.class);
	}

}
