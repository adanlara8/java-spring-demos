package com.adan.thymeleafwinelist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.adan.thymeleafwinelist.entity.WineReview;
import com.adan.thymeleafwinelist.images.MainWebAppInitializer;
import com.adan.thymeleafwinelist.service.WineReviewServiceImpl;

@Controller
public class MainController {

	@Autowired
	private WineReviewServiceImpl wineReviewServ;
	
	@GetMapping("/wine-list")
	public String wineList(Model viewModel) {	
		List<WineReview> allWineReviewsByScore = wineReviewServ.sortWineReviewByScore();	
		viewModel.addAttribute("allWineReviewsByScore",allWineReviewsByScore);
	
		return "wine-reviews/wine-list";
	}
	
	@GetMapping("/wine-review")
	public String showWineReview(@RequestParam("wineReviewId") int wineReviewId, Model viewModel) {;	
		WineReview theWine = wineReviewServ.findById(wineReviewId);
		if(theWine == null) {
			return "redirect:/wine-list";
		}		
		viewModel.addAttribute("theWine",theWine);		
		return "wine-reviews/wine-review";
	}
	
	@GetMapping("/review-form")
	public String showWineReviewForm(@ModelAttribute("newWine") WineReview newWine, Model viewModel) {		
		viewModel.addAttribute("newWine", newWine);		
		return "wine-reviews/wine-review-form";
	}
	
	@PostMapping("/add-review")
	public String addReview(@Valid @ModelAttribute("newWine") WineReview newWine,
			BindingResult result, RedirectAttributes redidAttrs,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException{
		
		if(result.hasErrors()) {
			return "wine-reviews/wine-review-form";
		}
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());  	
		newWine.setPicture(fileName);
	        		
		wineReviewServ.saveWineReview(newWine);
       
		String uploadDirectory = "./wine-pictures/" +newWine.getId();
		
		Path uploadPath = Paths.get(uploadDirectory);
		
		if( !Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch  (IOException e) {
			throw new IOException("could not save upload file: " + fileName);
		}
		
		redidAttrs.addFlashAttribute("success", "The review has been saved successfully"); 		
		return "redirect:/review-form";
	}
	
	@GetMapping("/delete-review")
	public String deleteWineReview(@RequestParam("wineReviewId") int wineReviewId) {;	
	wineReviewServ.deleteWineReviewById(wineReviewId);
		
		return "redirect:/wine-list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("wineName") String wineName, Model viewModel) {	
		if(wineName.isBlank()) {
			return "redirect:/wine-list";
		}		
		List<WineReview> searchResults = wineReviewServ.findWineReviewByName(wineName);
		viewModel.addAttribute("searchResults", searchResults);
		if(searchResults.isEmpty()) {
			return "redirect:/wine-list";
		}
		return "wine-reviews/search-results";
		
	}
	
}
