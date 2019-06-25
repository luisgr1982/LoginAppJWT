package com.at.loginapp.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.at.loginapp.model.User;
import com.at.loginapp.repository.UserRepository;

@Component
public class UserH2DetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.get().getRoles().stream().forEach(b->authorities.add(new SimpleGrantedAuthority(b.getName())));
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(),user.get().getPassword(),authorities);
	}

}
