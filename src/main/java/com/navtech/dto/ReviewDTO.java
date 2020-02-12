package com.navtech.dto;

import com.navtech.dto.models.ReviewDTOModel;

public interface ReviewDTO {

	boolean addReview(ReviewDTOModel reviewDTOModel, String certificateId);

}
