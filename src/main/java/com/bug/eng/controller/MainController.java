package com.bug.eng.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bug.eng.entity.Word;
import com.bug.eng.service.WordService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final WordService wordService;
	
	@GetMapping({"", "/"})
	public String index(Model model) {
		
		List<Word> nWords = wordService.findByType("명사");
		List<Word> vWords = wordService.findByType("동사");
		List<Word> aWords = wordService.findByType("형용사");
		
		model.addAttribute("nouns", nWords.size());
		model.addAttribute("verbs", vWords.size());
		model.addAttribute("adjectives", aWords.size());
		
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam(defaultValue = "", required = false) String searchText) {
		
		List<Word> searchWords = wordService.findByEngContainingOrMeaningContaining(searchText, searchText);
		model.addAttribute("searchWords", searchWords);
		
		return "search";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {
		
		Word word = wordService.findById(id);
		model.addAttribute("word", word);
		
		return "/modify";
	}

}
