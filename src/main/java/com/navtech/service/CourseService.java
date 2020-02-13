package com.navtech.service;

import java.util.List;

import com.navtech.models.Course;

public interface CourseService {

	Course addCourse(Course course);

	Course getCourseFromCourseName(String courseName);

	List<Course> getStudentCourseList(String username);

	String deleteCourse(String courseName);

}
