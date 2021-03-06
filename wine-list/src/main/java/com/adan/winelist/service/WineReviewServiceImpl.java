package com.adan.winelist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adan.winelist.dao.WineReviewRepository;
import com.adan.winelist.entity.WineReview;
@Service
public class WineReviewServiceImpl implements WineReviewService {

	@Autowired
	private WineReviewRepository wineReviewRepo;
	
	@Override
	public List<WineReview> findAll() {
		return (List<WineReview>) wineReviewRepo.findAll();
		
	}

	@Override
	public List<WineReview> sortWineReviewByScore() {		
		return wineReviewRepo.findAllByOrderByScoreDesc();
	}
	
	@Override
	public List<WineReview> findWineReviewByName(String theWineName) {		
		return wineReviewRepo.findByNameContainsAllIgnoreCase(theWineName);
	}

	@Override
	public void saveWineReview(WineReview theWine) {
		wineReviewRepo.save(theWine);

	}

	@Override
	public void deleteWineReviewById(int wineId) {
		wineReviewRepo.deleteById(wineId);

	}

	@Override
	public WineReview findById(int theId) {
		return wineReviewRepo.findById(theId).orElse(null);
	}

}
