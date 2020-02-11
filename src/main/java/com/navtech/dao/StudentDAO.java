package com.navtech.dao;

import java.util.List;

import com.navtech.models.Student;

public interface StudentDAO {

	Student addStudent(Student student);

	List<Student> getAllTheStudents();

	boolean updateStudent(Student student);

}
