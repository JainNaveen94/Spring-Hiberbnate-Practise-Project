package com.navtech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navtech.dao.ReviewDAO;
import com.navtech.models.Certificate;
import com.navtech.models.Review;
import com.navtech.service.CertificateService;
import com.navtech.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {
	
	
	@Autowired
	ReviewDAO reviewDao;
	
	@Autowired
	CertificateService certificateService;

	@Override
	public boolean addReview(Review review, String certificateId) {
		Certificate certificate = this.certificateService.getCertificate(certificateId);
		if(certificate != null) {
			return this.reviewDao.addReview(review, certificate);
		} else {
			return false;
		}
	}
	
	
}
