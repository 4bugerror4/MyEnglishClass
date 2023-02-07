package com.bug.eng.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.eng.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
