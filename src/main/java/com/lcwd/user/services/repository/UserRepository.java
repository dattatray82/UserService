package com.lcwd.user.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.services.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	// if you want to implements any custom method or query write here
}
