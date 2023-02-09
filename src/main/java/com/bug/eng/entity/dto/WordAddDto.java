package com.bug.eng.entity.dto;

import com.bug.eng.entity.User;
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
public class WordAddDto {
	
	private String type;
	private String eng;
	private String meaning;
	private User user;
	
	public Word toEntity(String type, String eng, String meaning, User user) {
		return Word.builder()
				.type(type)
				.eng(eng)
				.meaning(meaning)
				.user(user)
				.build();
	}

}
