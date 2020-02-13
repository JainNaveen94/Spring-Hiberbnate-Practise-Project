package com.navtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navtech.models.Course;

public interface CourseRepositories extends JpaRepository<Course, Long> {

}
