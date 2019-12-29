package com.jjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
