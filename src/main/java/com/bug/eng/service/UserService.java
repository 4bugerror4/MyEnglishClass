package com.bug.eng.service;

import com.bug.eng.entity.User;

public interface UserService {
	
	User save(User  user);
	
	User findByUsername(String username);
	
	User modify(User user);
	
	void deleteById(Long id);

}
