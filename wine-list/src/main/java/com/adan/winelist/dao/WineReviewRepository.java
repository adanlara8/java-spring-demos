package com.adan.winelist.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adan.winelist.entity.WineReview;

public interface WineReviewRepository extends CrudRepository<WineReview, Integer> {

	public List<WineReview> findAllByOrderByScoreDesc();
	
	public List<WineReview> findByNameContainsAllIgnoreCase(String theWineName);
	
}
