package com.navtech.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="studId")
	private long studId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_detail_id")
	private StudentDetail studentDetail;
	
	@OneToMany(mappedBy = "student", cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	private List<Certificate> certificateList;
	
	/* Default Constructor */
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter / Setters */

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public List<Certificate> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(List<Certificate> certificateList) {
		this.certificateList = certificateList;
	}

}
