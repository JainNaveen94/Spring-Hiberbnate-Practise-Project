package com.navtech.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navtech.dto.StudentDTO;
import com.navtech.dto.models.CertificateDTOModel;
import com.navtech.dto.models.StudentDTOModel;
import com.navtech.models.Student;
import com.navtech.models.StudentDetail;
import com.navtech.models.Certificate;
import com.navtech.service.StudentService;


@Component
public class StudentDTOImpl implements StudentDTO {
	
	/* Services Used Inside The Student DTO's*/
	
	@Autowired
	StudentService studentService;
	

	@Override
	public StudentDTOModel addStudent(StudentDTOModel studentdtomodel) {
		 Student student = this.createStudentFromStudentDTOModel(studentdtomodel);
		 return this.createStudentDTOModelFromStudent(this.studentService.addStudent(student));
	}

	private StudentDTOModel createStudentDTOModelFromStudent(Student student) {
		StudentDTOModel studentdtomodel = new StudentDTOModel();
		studentdtomodel.setUsername(student.getUsername());
		studentdtomodel.setPassword(student.getPassword());
		studentdtomodel.setEmail(student.getEmail());
		studentdtomodel.setYoutube_channel(student.getStudentDetail().getYoutube_channel());
		studentdtomodel.setHobbies(student.getStudentDetail().getHobbies());
		return studentdtomodel;
	}

	private Student createStudentFromStudentDTOModel(StudentDTOModel studentdtomodel) {
		Student student = new Student();
		student.setEmail(studentdtomodel.getEmail());
		student.setUsername(studentdtomodel.getUsername());
		student.setPassword(studentdtomodel.getPassword());
		student.setStudentDetail(this.createStudentDetail(studentdtomodel));
		return student;
	}

	private StudentDetail createStudentDetail(StudentDTOModel studentdtomodel) {
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setYoutube_channel(studentdtomodel.getYoutube_channel());
		studentDetail.setHobbies(studentdtomodel.getHobbies());
		return studentDetail;
	}

	@Override
	public String issueCertificateToStudent(String certificateId, String username) {
		return this.studentService.issueCertificateToStudent(certificateId, username);
	}

	@Override
	public List<CertificateDTOModel> getCertificateListOfStudent(String username) {
		List<Certificate> certificates = this.studentService.getCertificateListOfStudent(username);
		return this.createCertificateDTOModelListFromCertificateList(certificates);
		
	}

	private List<CertificateDTOModel> createCertificateDTOModelListFromCertificateList(List<Certificate> certificates) {
		List<CertificateDTOModel> certificateDTOModels = new ArrayList<CertificateDTOModel>();
		if(certificates.size() > 0) {
			for(Certificate certificateObj: certificates) {
				certificateDTOModels.add(this.createCertificateDTOModelFromCertificate(certificateObj));
			}
		}
		return certificateDTOModels;
	}

	private CertificateDTOModel createCertificateDTOModelFromCertificate(Certificate certificate) {
		CertificateDTOModel certificateDTOModel = new CertificateDTOModel();
		certificateDTOModel.setCertificateId(certificate.getCertificateId());
		certificateDTOModel.setCertificateTitle(certificate.getCertificateTitle());
		certificateDTOModel.setCertificateDescription(certificate.getCertificateDescription());
		return certificateDTOModel;
	}

	@Override
	public String enrolledForTheCourse(String studentUserName, String courseName) {
		return this.studentService.enrolledForTheCourse(studentUserName, courseName);
	}

}
