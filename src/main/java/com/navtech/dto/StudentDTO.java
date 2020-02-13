package com.navtech.dto;

import java.util.List;

import com.navtech.dto.models.CertificateDTOModel;
import com.navtech.dto.models.StudentDTOModel;

public interface StudentDTO {

	StudentDTOModel addStudent(StudentDTOModel studentdtomodel);

	String issueCertificateToStudent(String certificateId, String username);

	List<CertificateDTOModel> getCertificateListOfStudent(String username);

	String enrolledForTheCourse(String studentUserName, String courseName);

}
