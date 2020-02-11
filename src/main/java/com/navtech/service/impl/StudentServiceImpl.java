package com.navtech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navtech.dao.StudentDAO;
import com.navtech.models.Certificate;
import com.navtech.models.Student;
import com.navtech.service.CertificateService;
import com.navtech.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	/* */
	
	@Autowired
	StudentDAO studentDao;
	
	@Autowired
	CertificateService certificateService;

	@Override
	public Student addStudent(Student student) {
		return this.studentDao.addStudent(student);
	}

	@Override
	public String issueCertificateToStudent(String certificateId, String username) {
		List<Student> students = this.studentDao.getAllTheStudents();
		Certificate certificate = this.certificateService.getCertificate(certificateId);
		if(students.size() > 0 && certificate != null) {
			for(Student studentObj: students) {
				if(studentObj.getUsername().equalsIgnoreCase(username)) {
					studentObj.getCertificateList().add(certificate);
					certificate.setStudent(studentObj);
					boolean studentUpdated = this.studentDao.updateStudent(studentObj);
					if(studentUpdated) {
						return "Certificate With CertificateID :: " + certificateId 
								+ " is Successfully issued to " + studentObj.getUsername();
					} else {
						return "Certificate With CertificateID :: " + certificateId 
								+ " is Not issued to " + studentObj.getUsername() + " due to Some Internal Error.";
					}
				}
			}
		} else if(students.size() <= 0) {
			return "Certificate With CertificateID :: " + certificateId 
					+ " is not Issued due to Invalid " + username;
		} else {
			return "Certificate With CertificateID :: " + certificateId 
					+ " is not valid Certificate ID";
		}
		return "Internal Server Error Occured";
	}

	@Override
	public List<Certificate> getCertificateListOfStudent(String username) {
		Student student = this.getStudentFromStudentList(username);
		if(student != null) {
			return student.getCertificateList();
		}
		return new ArrayList<Certificate>();
	}

	private Student getStudentFromStudentList(String username) {
		List<Student> students = this.studentDao.getAllTheStudents();
		if(students.size() > 0) {
			for(Student studentObj: students)  {
				if(studentObj.getUsername().equals(username)) {
					return studentObj;
				}
			}
		}
		return null;
	}
	

}
