package com.bug.eng.service;

import java.util.List;
import java.util.function.Supplier;

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
	
	@Transactional
	@Override
	public Word modify(Word word) {
		
		Word wordEntity = wordRepository.findById(word.getId()).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {

				return new IllegalArgumentException("해당 아이디는 존재하지 않습니다. : " + word.getId());
			}
		});
		
		wordEntity.setEng(word.getEng());
		wordEntity.setMeaning(word.getMeaning());

		return wordEntity;
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
	public List<Word> findByEngContainingOrMeaningContaining(String eng, String meaning) {

		return wordRepository.findByEngContainingOrMeaningContaining(eng, meaning);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Word> findByUserId(Pageable pageable, Long id) {
		
		return wordRepository.findByUserId(pageable, id);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Word> findByUserIdAndEngContaining(Pageable pageable, Long id, String eng) {

		return wordRepository.findByUserIdAndEngContaining(pageable, id, eng);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Word> findByUserIdAndMeaningContaining(Pageable pageable, Long id, String meaning) {

		return wordRepository.findByUserIdAndMeaningContaining(pageable, id, meaning);
	}

	@Transactional(readOnly = true)
	@Override
	public Word findById(Long id) {

		return wordRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				
				return new IllegalArgumentException("해당 아이디는 존재하지 않습니다. : " + id);
			}
		});
	}

}
