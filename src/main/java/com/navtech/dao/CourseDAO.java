package com.navtech.dao;

import java.util.List;

import com.navtech.models.Course;

public interface CourseDAO {

	Course addCourse(Course course);

	List<Course> getAllTheCourses();

	boolean deleteCourse(Course course);

}
