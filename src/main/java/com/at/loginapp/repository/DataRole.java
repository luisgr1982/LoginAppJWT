package com.at.loginapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.at.loginapp.model.Role;

@Component
public class DataRole implements CommandLineRunner{

	@Autowired
	public RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role("ROLE_USER"));
		roleRepository.save(new Role("ROLE_ADMIN"));
	}

}
