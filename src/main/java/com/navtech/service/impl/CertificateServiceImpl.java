package com.navtech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navtech.dao.CertificateDAO;
import com.navtech.models.Certificate;
import com.navtech.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {
	
	
	@Autowired
	private CertificateDAO certificateDao;

	@Override
	public Certificate addCertificate(Certificate certificate) {
		if(this.checkForUniqueCertificateTitle(certificate)) {
			return this.certificateDao.addCertificate(certificate);
		} else {
			return null;
		}
	}

	
	//Used to Check the Uniqueness of Certificate Title
	private boolean checkForUniqueCertificateTitle(Certificate certificate) {
		List<Certificate> certificateList = this.certificateDao.getCertificateList();
		for(Certificate certificateObj: certificateList) {
			if(certificateObj.getCertificateTitle().equalsIgnoreCase(certificate.getCertificateTitle())) {
				return false;
			}
		}
		return true;
	}


	@Override
	public List<Certificate> getCertificateList() {
		return this.certificateDao.getCertificateList();
	}


	@Override
	public String deleteCertificate(String certificateId) {
		List<Certificate> certificateList = this.certificateDao.getCertificateList();
		if(certificateList.size() > 0) {
			Certificate certificate = this.findCertificateByCertificateID(certificateList, certificateId);
			if(certificate != null) {
				return this.certificateDao.deleteCertificate(certificate);
			} else {
				return "Certificate With Certificate ID :: " + certificateId + "is Not Available";
			}
		} else {
			return "Certificate With Certificate ID :: " + certificateId + "is Not Available";
		}
	}


	private Certificate findCertificateByCertificateID(List<Certificate> certificateList, String certificateId) {
		for(Certificate certificateObj: certificateList) {
			if(certificateObj.getCertificateId().equals(certificateId)) {
				return certificateObj;
			}
		}
		return null;
	}


	@Override
	public Certificate getCertificate(String certificateId) {
		List<Certificate> certificates = this.certificateDao.getCertificateList();
		if(certificates.size() > 0) {
			for(Certificate certificateObj: certificates) {
				if(certificateObj.getCertificateId().equalsIgnoreCase(certificateId)) {
					return certificateObj;
				}
			}
		} else {
			return null;
		}
		return null;
	}
	
	
}
