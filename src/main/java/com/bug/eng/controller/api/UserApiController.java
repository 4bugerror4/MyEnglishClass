package com.bug.eng.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bug.eng.entity.dto.ResponseDto;
import com.bug.eng.entity.dto.UserDeleteDto;
import com.bug.eng.entity.dto.UserSaveDto;
import com.bug.eng.entity.dto.UserUpdateDto;
import com.bug.eng.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {
	
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/api/user/join")
	public ResponseDto<Integer> join(@RequestBody UserSaveDto dto) {
		
		userService.save(dto.toEntity(dto.getUsername(), dto.getPassword(), dto.getEmail()));
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/auth/api/user/modify")
	public ResponseDto<Integer> modify(@RequestBody UserUpdateDto dto) {
		
		userService.modify(dto.toEntity(dto.getUsername(), dto.getPassword(), dto.getEmail()));
		
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/auth/api/user/delete")
	public ResponseDto<Integer> delete(@RequestBody UserDeleteDto dto) {
		
		System.out.println(dto.getId());
		
		userService.deleteById(dto.getId());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
