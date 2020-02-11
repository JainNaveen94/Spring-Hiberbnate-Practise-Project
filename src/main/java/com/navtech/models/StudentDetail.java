package com.navtech.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StudentDetail")
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtube_channel;
	
	@Column(name="hobbies")
	private String[] hobbies;
	
	@OneToOne(mappedBy = "studentDetail", 
			cascade = {CascadeType.PERSIST,
						CascadeType.MERGE,
						CascadeType.REFRESH,
						CascadeType.DETACH})
	private Student student;
	
	/* Default Constructor */
	
	public StudentDetail() {
		// TODO Auto-generated constructor stub
	}
	

	
	/* Setter / Getter */
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	

}
