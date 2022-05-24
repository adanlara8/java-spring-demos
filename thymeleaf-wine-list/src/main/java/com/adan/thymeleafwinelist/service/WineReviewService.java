package com.adan.thymeleafwinelist.service;

import java.util.List;

import com.adan.thymeleafwinelist.entity.WineReview;

public interface WineReviewService {

	public List<WineReview> findAll();
	
	public List<WineReview> findWineReviewByName(String theWineName);
	
	public List<WineReview> sortWineReviewByScore();
	
	public WineReview findById(int theId);	
	
	public void saveWineReview(WineReview theWine);
	
	public void deleteWineReviewById(int wineId);

	
}
