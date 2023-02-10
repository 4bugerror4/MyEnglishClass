package com.bug.eng.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Transactional(readOnly = true)
	@Override
	public List<Word> findByType(String type) {

		return wordRepository.findByType(type);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Word> findByType(Pageable pageable, String type) {

		return wordRepository.findByType(pageable, type);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Word> findByTypeAndEngContainingOrMeaningContaining(Pageable pageable, String type, String eng, String meaning) {

		return wordRepository.findByTypeAndEngContainingOrMeaningContaining(pageable, type, eng, meaning);
	}

}
