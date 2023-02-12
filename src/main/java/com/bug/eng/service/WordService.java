package com.bug.eng.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bug.eng.entity.Word;

public interface WordService {
	
	Word save(Word word);
	Word modify(Word word);
	List<Word> findByType(String type);
	List<Word> findByEngContainingOrMeaningContaining(String eng, String meaning);
	Page<Word> findByType(Pageable pageable, String type);
	
	Page<Word> findByUserId(Pageable pageable, Long id);
	Page<Word> findByUserIdAndEngContaining(Pageable pageable, Long id, String eng);
	Page<Word> findByUserIdAndMeaningContaining(Pageable pageable, Long id, String meaning);
	
	Word findById(Long id);
	void deleteById(Long id);
	
}
