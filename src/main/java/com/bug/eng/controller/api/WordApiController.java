package com.bug.eng.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bug.eng.config.auth.PrincipalDetails;
import com.bug.eng.entity.dto.ResponseDto;
import com.bug.eng.entity.dto.WordAddDto;
import com.bug.eng.entity.dto.WordModifyDto;
import com.bug.eng.service.WordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WordApiController {
	
	private final WordService wordService;
	
	@PostMapping("/api/word/add")
	public ResponseDto<Integer> wordAdd(@RequestBody WordAddDto dto, @AuthenticationPrincipal PrincipalDetails principal) {
		
		System.out.println(dto.getType());
		System.out.println(dto.getEng());
		System.out.println(dto.getMeaning());
		System.out.println(principal.getUser());
		
		wordService.save(dto.toEntity(dto.getType(), dto.getEng(), dto.getMeaning(), principal.getUser()));
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/api/word/modify")
	public ResponseDto<Integer> wordModify(@RequestBody WordModifyDto dto, @AuthenticationPrincipal PrincipalDetails principal) {
		
		System.out.println(dto.getId());
		System.out.println(dto.getType());
		System.out.println(dto.getEng());
		System.out.println(dto.getMeaning());
		
		wordService.modify(dto.toEntity(dto.getId(), dto.getType(), dto.getEng(), dto.getMeaning()));
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
