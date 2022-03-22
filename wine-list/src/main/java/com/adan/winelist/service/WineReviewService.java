package com.adan.winelist.service;

import java.util.List;

import com.adan.winelist.entity.WineReview;

public interface WineReviewService {

	public List<WineReview> findAll();
	
	public List<WineReview> findWineReviewByName(String theWineName);
	
	public List<WineReview> sortWineReviewByScore();
	
	public WineReview findById(int theId);	
	
	public void saveWineReview(WineReview theWine);
	
	public void deleteWineReviewById(int wineId);

	
}
