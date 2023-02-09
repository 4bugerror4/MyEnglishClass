package com.bug.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.eng.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long>{
	

}
