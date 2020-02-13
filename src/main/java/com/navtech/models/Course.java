package com.navtech.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="courseId")
	private long courseId;
	
	@Column(name="courseName")
	private String courseName;
	
	@Column(name="courseDuration")
	private String courseDuration;
	
	@Column(name="courseDescription")
	private String courseDescription;
	
	@Column(name="courseFees")
	private float courseFees;
	
	
	@ManyToMany(cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinTable(
		name="Student_Course",
		joinColumns = @JoinColumn(name="courseId"),
		inverseJoinColumns = @JoinColumn(name="studentId")
	)
	private List<Student> students;
	
	/* Default Constructor */
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter / Setter */

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

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

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public float getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(float courseFees) {
		this.courseFees = courseFees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
