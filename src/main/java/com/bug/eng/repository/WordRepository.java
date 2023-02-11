package com.bug.eng.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.eng.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long>{
	
	List<Word> findByType(String type);
	List<Word> findByEngContainingOrMeaningContaining(String eng, String meaning);
	Page<Word> findByType(Pageable pageable, String type);
	
	Page<Word> findByUserId(Pageable pageable, Long id);
	List<Word> findByUserIdAndEngContaining(Long id, String eng);
	List<Word> findByUserIdAndMeaningContaining(Long id, String meaning);
	
}
