package com.navtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navtech.models.Review;

public interface ReviewRepositories extends JpaRepository<Review, Long> {

}
