package com.navtech.dao;

import java.util.List;

import com.navtech.models.Certificate;

public interface CertificateDAO {

	Certificate addCertificate(Certificate certificate);

	List<Certificate> getCertificateList();

	String deleteCertificate(Certificate certificate);

}
