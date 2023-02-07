package com.bug.eng.service;

import java.util.function.Supplier;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.eng.entity.User;
import com.bug.eng.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;


	@Transactional
	@Override
	public User save(User dto) {
		
		String rawPassword = dto.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		dto.setPassword(encPassword);
		dto.setRole("ROLE_USER");
		
		return userRepository.save(dto);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByUsername(String username) {
		
		User user = userRepository.findByUsername(username).orElseThrow(new Supplier<UsernameNotFoundException>() {

			@Override
			public UsernameNotFoundException get() {

				return new UsernameNotFoundException("해당 아이디는 존재하지 않습니다. : " + username);
			}
		});

		return user;
	}

	@Transactional
	@Override
	public User modify(User dto) {

		User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(new Supplier<UsernameNotFoundException>() {

			@Override
			public UsernameNotFoundException get() {

				return new UsernameNotFoundException("해당 아이디는 존재하지 않습니다. : " + dto.getUsername());
			}
		});
		
		String rawPassword = dto.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		user.setPassword(encPassword);
		user.setEmail(dto.getEmail());
		
		return user;
	}

	@Transactional
	@Override
	public void deleteById(Long id) {

		userRepository.deleteById(id);
	}

}
