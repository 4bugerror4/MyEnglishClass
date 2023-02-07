package com.bug.eng.entity.dto;

import com.bug.eng.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSaveDto {
	
	private String username;
	private String password;
	private String email;
	private String role; 
	
	public User toEntity(String username, String password, String email) {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
	}

}
