package com.navtech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navtech.dao.CourseDAO;
import com.navtech.models.Course;
import com.navtech.models.Student;
import com.navtech.service.CourseService;
import com.navtech.service.StudentService;


@Service
public class CourseServiceImpl implements CourseService{

	
	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private StudentService studentService;

	@Override
	public Course addCourse(Course course) {
		return this.courseDao.addCourse(course);
	}

	@Override
	public Course getCourseFromCourseName(String courseName) {
		List<Course> courses = this.courseDao.getAllTheCourses();
		if(courses.size() > 0) {
			for(Course courseObj: courses) {
				if(courseObj.getCourseName().equalsIgnoreCase(courseName)) {
					return courseObj;
				}
			}
		}
		return null;
	}

	@Override
	public List<Course> getStudentCourseList(String username) {
		Student student = this.studentService.getStudentFromStudentList(username);
		if(student != null) {
			return student.getCourses();
		} else {
			return new ArrayList<Course>();
		}
	}

	@Override
	public String deleteCourse(String courseName) {
		Course course = this.getCourseFromCourseName(courseName);
		if(course != null) {
			boolean result = this.courseDao.deleteCourse(course);
			if(result) {
				return courseName + "is Successfully Deleted From the System";
			} else {
				return "Internal Server Error Occured While Deleting the " + courseName;
			}
		} else {
			return courseName + " Is Not Available to Delete.";
		}
	}
}
