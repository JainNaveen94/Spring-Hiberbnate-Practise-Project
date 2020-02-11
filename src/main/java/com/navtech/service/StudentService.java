package com.navtech.service;

import java.util.List;

import com.navtech.models.Certificate;
import com.navtech.models.Student;

public interface StudentService {

	Student addStudent(Student student);

	String issueCertificateToStudent(String certificateId, String username);

	List<Certificate> getCertificateListOfStudent(String username);
	
	

}
