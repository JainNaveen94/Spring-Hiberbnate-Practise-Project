package com.navtech.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navtech.dto.ReviewDTO;
import com.navtech.dto.models.ReviewDTOModel;
import com.navtech.models.Review;
import com.navtech.service.ReviewService;

@Component
public class ReviewDTOImpl implements ReviewDTO {

	
	@Autowired
	ReviewService reviewService;

	@Override
	public boolean addReview(ReviewDTOModel reviewDTOModel, String certificateId) {
		Review review = this.createReviewFromReviewDTOModel(reviewDTOModel);
		return this.reviewService.addReview(review, certificateId);
	}

	private Review createReviewFromReviewDTOModel(ReviewDTOModel reviewDTOModel) {
		Review review = new Review();
		review.setComment(reviewDTOModel.getComment());
		return review;
	}
	
	@SuppressWarnings("unused")
	private ReviewDTOModel createReviewDTOModelFromReview(Review review) {
		ReviewDTOModel reviewDTOModel = new ReviewDTOModel();
		reviewDTOModel.setComment(review.getComment());
		return reviewDTOModel;
	}
	
	
}
