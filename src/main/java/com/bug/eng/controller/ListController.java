package com.bug.eng.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bug.eng.entity.Word;
import com.bug.eng.service.WordService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ListController {
	
	private final WordService wordService;
	
	@GetMapping("/list/nouns")
	public String nounList(Model model, @PageableDefault(size = 20, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<Word> nList = wordService.findByType(pageable, "명사");
		
		int starPage = Math.max(1, nList.getPageable().getPageNumber() - 4);
		int endPage = Math.min(nList.getTotalPages(), nList.getPageable().getPageNumber() + 4);
		
		model.addAttribute("nList", nList);
		model.addAttribute("startPage", starPage);
		model.addAttribute("endPage", endPage);
		
		return "/lists/nList";
	}
	
	@GetMapping("/list/verbs")
	public String verbList(Model model, @PageableDefault(size = 20, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<Word> vList = wordService.findByType(pageable, "동사");
		
		int starPage = Math.max(1, vList.getPageable().getPageNumber() - 4);
		int endPage = Math.min(vList.getTotalPages(), vList.getPageable().getPageNumber() + 4);
		
		model.addAttribute("vList", vList);
		model.addAttribute("startPage", starPage);
		model.addAttribute("endPage", endPage);
		
		return "/lists/vList";
	}
	
	@GetMapping("/list/adjectives")
	public String adjectiveList(Model model, @PageableDefault(size = 20, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<Word> adjList = wordService.findByType(pageable, "형용사");
		
		int starPage = Math.max(1, adjList.getPageable().getPageNumber() - 4);
		int endPage = Math.min(adjList.getTotalPages(), adjList.getPageable().getPageNumber() + 4);
		
		model.addAttribute("adjList", adjList);
		model.addAttribute("startPage", starPage);
		model.addAttribute("endPage", endPage);
		
		return "/lists/adjList";
	}


}
