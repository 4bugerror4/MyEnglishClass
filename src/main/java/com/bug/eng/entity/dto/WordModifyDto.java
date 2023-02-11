package com.bug.eng.entity.dto;

import com.bug.eng.entity.Word;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordModifyDto {
	
	private Long id;
	private String type;
	private String eng;
	private String meaning;
	
	public Word toEntity(Long id, String type, String eng, String meaning) {
		return Word.builder()
				.id(id)
				.type(type)
				.eng(eng)
				.meaning(meaning)
				.build();
	}

}
