package com.adan.winelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adan.winelist.entity.WineReview;
import com.adan.winelist.service.WineReviewServiceImpl;

@Controller
public class MainController {

	@Autowired
	private WineReviewServiceImpl wineReviewServ;
	
	@GetMapping("/wine-list")
	public String wineList(Model viewModel) {
		
	
		List<WineReview> allWineReviewsByScore = wineReviewServ.sortWineReviewByScore();
		
		viewModel.addAttribute("allWineReviewsByScore",allWineReviewsByScore);
		
		
		return "/wine-list";
	}
	
	@GetMapping("/wine-review/{wineId}")
	public String showWineReview(@PathVariable("wineId") int wineId, Model viewModel) {;
		WineReview theWine = wineReviewServ.findById(wineId);
		
		viewModel.addAttribute("theWine",theWine);
		
		return "wine-review";
	}
	
	@GetMapping("/review-form")
	public String showWineReviewForm(@ModelAttribute("newWine") WineReview newWine, Model viewModel) {		
	
		viewModel.addAttribute("newWine", newWine);
		
		return "wine-review-form";
	}
	
	@PostMapping("/add-review")
	public String addReview(@ModelAttribute("newWine") WineReview newWine, Model viewModel) {
		
		wineReviewServ.saveWineReview(newWine);
		
		return "redirect:/wine-list";
	}
	
	@GetMapping("/delete-review/{wineId}")
	public String deleteWineReview(@PathVariable("wineId") int wineId) {;
	
	wineReviewServ.deleteWineReviewById(wineId);
		
		return "redirect:/wine-list";
	}
	
}
