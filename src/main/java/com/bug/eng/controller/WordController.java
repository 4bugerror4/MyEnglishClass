package com.bug.eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WordController {
	
	@GetMapping("/words/noun/add")
	public String nounAdd() {
		return "words/noun";
	}
	
	@GetMapping("/words/verb/add")
	public String verbAdd() {
		return "words/verb";
	}
	
	@GetMapping("/words/adjective/add")
	public String adjectiveAdd() {
		return "words/adjective";
	}

}
