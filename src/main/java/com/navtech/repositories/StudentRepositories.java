package com.navtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navtech.models.Student;

public interface StudentRepositories extends JpaRepository<Student, Long> {

	Student findByUsername(String username);
}
