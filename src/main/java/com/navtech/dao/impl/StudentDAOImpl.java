package com.navtech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navtech.dao.StudentDAO;
import com.navtech.models.Student;
import com.navtech.repositories.StudentRepositories;


@Repository
public class StudentDAOImpl implements StudentDAO {
	
	/* */
	
	@Autowired
	StudentRepositories studentRepositories;

	@Override
	public Student addStudent(Student student) {
		try {
			this.studentRepositories.save(student);
			return student;
		} catch(Exception exception) {
			System.out.println("Student Add Exception " + exception);
			return null;
		}
	}

	@Override
	public List<Student> getAllTheStudents() {
		try {
			return this.studentRepositories.findAll();
		} catch(Exception exception) {
			System.out.println("Fetch All The Student Exception " + exception);
			return new ArrayList<Student>();
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		try {
			this.studentRepositories.save(student);
			return true;
		} catch(Exception exception) {
			System.out.println("Student Update Exception " + exception);
			return false;
		}
	}

}
