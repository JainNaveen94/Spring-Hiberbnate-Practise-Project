package com.navtech.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navtech.dao.ReviewDAO;
import com.navtech.models.Certificate;
import com.navtech.models.Review;
import com.navtech.repositories.ReviewRepositories;


@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	ReviewRepositories reviewRepositories;

	@Override
	public boolean addReview(Review review, Certificate certificate) {
		try {
			certificate.getReviews().add(review);
			this.reviewRepositories.save(review);
			return true;
		} catch(Exception exception) {
			System.out.println("Review Adding Exception" + exception);
			return false;
		}
	}
	
	
	
}
