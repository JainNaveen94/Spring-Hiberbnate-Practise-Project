package com.navtech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navtech.dao.CourseDAO;
import com.navtech.models.Course;
import com.navtech.repositories.CourseRepositories;


@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private CourseRepositories courseRepositories;

	@Override
	public Course addCourse(Course course) {
		try {
			this.courseRepositories.save(course);
			return course;
		} catch(Exception exception) {
			System.out.println("Course Adding Exception :: " + exception);
			return null;
		}
	}

	@Override
	public List<Course> getAllTheCourses() {
		try {
			return this.courseRepositories.findAll();
		} catch(Exception exception) {
			System.out.println("Fetching List Of All The Available Courses Exception" + exception);
			return new ArrayList<Course>();
		}
	}

	@Override
	public boolean deleteCourse(Course course) {
		try {
			this.courseRepositories.delete(course);
			return true;
		} catch(Exception exception) {
			System.out.println("Course Deleting Exception" + exception);
			return false;
		}
	}
}
