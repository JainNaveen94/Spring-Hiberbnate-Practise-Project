package com.navtech.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="certificateTitle")
	private String certificateTitle;
	
	@Column(name="certificateId")
	private String certificateId;
	
	@Column(name="certificateDescription")
	private String certificateDescription;
	
	@ManyToOne(cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(name="student_id")
	private Student student;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="certificateId")
	private List<Review> reviews;
	
	/* Default Constructor */
	
	public Certificate() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter / Setter */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCertificateTitle() {
		return certificateTitle;
	}

	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateDescription() {
		return certificateDescription;
	}

	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}
