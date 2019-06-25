package com.at.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.loginapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String role);
}
