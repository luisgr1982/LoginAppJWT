package com.at.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.loginapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	/**
	 * Metodo que busca un usuario por su nombre
	 * 
	 * @param username
	 * @return devuelve un objeto User
	 */
	User findByUsername(String username);
	
	/**
	 * 
	 *Metodo que busca un usuario por su email
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
}
