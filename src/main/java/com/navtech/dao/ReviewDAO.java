package com.navtech.dao;

import com.navtech.models.Certificate;
import com.navtech.models.Review;

public interface ReviewDAO {

	boolean addReview(Review review, Certificate certificate);

}
