package com.navtech.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navtech.dto.CourseDTO;
import com.navtech.dto.models.CourseDTOModel;
import com.navtech.models.Course;
import com.navtech.service.CourseService;


@Component
public class CourseDTOImpl implements CourseDTO {

	@Autowired
	private CourseService courseService;

	@Override
	public CourseDTOModel addCourse(CourseDTOModel courseDtoModel) {
		Course course = this.createCourseFromCorseDTOModel(courseDtoModel);
		course = this.courseService.addCourse(course);
		if(course != null) {
			return this.createCourseDTOModelFromCourse(course);
		} else {
			return null;
		}
	}

	private CourseDTOModel createCourseDTOModelFromCourse(Course course) {
		return new CourseDTOModel(course.getCourseName(), course.getCourseDuration(), 
				course.getCourseDescription(), course.getCourseFees());
	}

	private Course createCourseFromCorseDTOModel(CourseDTOModel courseDtoModel) {
		Course course = new Course();
		course.setCourseName(courseDtoModel.getCourseName());
		course.setCourseDescription(courseDtoModel.getCourseDescription());
		course.setCourseDuration(courseDtoModel.getCourseDuration());
		course.setCourseFees(courseDtoModel.getCourseFees());
		return course;
	}

	@Override
	public List<CourseDTOModel> getStudentCourseList(String username) {
		List<Course> courses = this.courseService.getStudentCourseList(username);
		if(courses.size() > 0) {
			return this.createCourseDTOListFromCourseList(courses);
		} else {
			return new ArrayList<CourseDTOModel>();
		}
	}

	private List<CourseDTOModel> createCourseDTOListFromCourseList(List<Course> courses) {
		List<CourseDTOModel> courseDtoModelList = new ArrayList<CourseDTOModel>();
		for(Course courseObj: courses) {
			courseDtoModelList.add(this.createCourseDTOModelFromCourse(courseObj));
		}
		return courseDtoModelList;
	}

	@Override
	public String deleteCourse(String courseName) {
		// TODO Auto-generated method stub
		return this.courseService.deleteCourse(courseName);
	}
}
