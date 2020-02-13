package com.navtech.dto.models;

public class CourseDTOModel {
	
	private String courseName;
	private String courseDuration;
	private float courseFees;
	private String courseDescription;
	
	/* Default Constructor */
	public CourseDTOModel() {
		// TODO Auto-generated constructor stub
	}
	
	/* Parameterized Constructor */
	
	public CourseDTOModel(String courseName, String courseDuration, 
				String courseDescription, float courseFees) {
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseDescription = courseDescription;
		this.courseFees = courseFees;
	}
	
	/* Getter / Setter */

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public float getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(float courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

}
