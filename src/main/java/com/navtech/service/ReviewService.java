package com.navtech.service;

import com.navtech.models.Review;

public interface ReviewService {

	boolean addReview(Review review, String certificateId);

}
