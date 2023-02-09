package com.bug.eng.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.eng.entity.Word;
import com.bug.eng.repository.WordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
	
	private final WordRepository wordRepository;

	@Transactional
	@Override
	public Word save(Word word) {
		
		return wordRepository.save(word);
	}

}
