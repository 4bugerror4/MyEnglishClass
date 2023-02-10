package com.bug.eng.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bug.eng.entity.Word;

public interface WordService {
	
	Word save(Word word);
	List<Word> findByType(String type);
	List<Word> findByEngContainingOrMeaningContaining(String eng, String meaning);
	Page<Word> findByType(Pageable pageable, String type);
	
}
