package com.navtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navtech.models.Certificate;

public interface CertificateRepositories extends JpaRepository<Certificate, Long> {

}
