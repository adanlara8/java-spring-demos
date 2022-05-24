package com.adan.thymeleafwinelist.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adan.thymeleafwinelist.entity.WineReview;

public interface WineReviewRepository extends CrudRepository<WineReview, Integer> {

	public List<WineReview> findAllByOrderByScoreDesc();
	
	public List<WineReview> findByNameContainsAllIgnoreCase(String theWineName);
	
}
