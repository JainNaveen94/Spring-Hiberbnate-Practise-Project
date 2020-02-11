package com.navtech.service;

import java.util.List;

import com.navtech.models.Certificate;

public interface CertificateService {

	Certificate addCertificate(Certificate certificate);

	List<Certificate> getCertificateList();

	String deleteCertificate(String certificateId);
	
	Certificate getCertificate(String certificateId);

}
