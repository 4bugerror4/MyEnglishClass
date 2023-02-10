package com.bug.eng.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bug.eng.entity.Word;
import com.bug.eng.repository.WordRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final WordRepository wordRepository;
	
	@GetMapping({"", "/"})
	public String index(Model model) {
		
		List<Word> nWords = wordRepository.findByType("명사");
		List<Word> vWords = wordRepository.findByType("동사");
		List<Word> aWords = wordRepository.findByType("형용사");
		
		model.addAttribute("nouns", nWords.size());
		model.addAttribute("verbs", vWords.size());
		model.addAttribute("adjectives", aWords.size());
		
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}

}
