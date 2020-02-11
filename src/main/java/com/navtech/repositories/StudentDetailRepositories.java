package com.navtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navtech.models.StudentDetail;

public interface StudentDetailRepositories extends JpaRepository<StudentDetail, Long> {

}
