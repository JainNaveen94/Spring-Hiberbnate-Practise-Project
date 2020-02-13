package com.navtech.dto;

import java.util.List;

import com.navtech.dto.models.CourseDTOModel;

public interface CourseDTO {

	CourseDTOModel addCourse(CourseDTOModel courseDtoModel);

	List<CourseDTOModel> getStudentCourseList(String username);

	String deleteCourse(String courseName);

}
