package com.navtech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.navtech.dao.CertificateDAO;
import com.navtech.models.Certificate;
import com.navtech.repositories.CertificateRepositories;

@Repository
public class CertificateDAOImpl implements CertificateDAO {
	
	@Autowired
	private CertificateRepositories certificateRepositories;

	@Override
	public Certificate addCertificate(Certificate certificate) {
		try {
			
			this.certificateRepositories.save(certificate);
			return certificate;
			
		} catch(Exception exception) {
			System.out.println("Certificate Add Exception" + exception);
			return null;
		}
	}

	@Override
	public List<Certificate> getCertificateList() {
		try {
			return this.certificateRepositories.findAll();
		} catch(Exception exception) {
			System.out.println("Fetch List Of Certificate Exception" + exception);
			return new ArrayList<Certificate>();
		}
	}

	@Override
	public String deleteCertificate(Certificate certificate) {
		try {
			if(certificate.getStudent() != null) {
				certificate.getStudent().getCertificateList().remove(certificate);
			}
			this.certificateRepositories.delete(certificate);
			return "Certificate With Certificate ID :: " + certificate.getCertificateId() + "is Deleted SuccessFully";
		} catch(Exception exception) {
			System.out.println("Certificate Delete Exception " + exception);
			return "Internal Server Error While Deleting The Certificate With Certificate ID :: " + certificate.getCertificateId();
		}
	}

}
