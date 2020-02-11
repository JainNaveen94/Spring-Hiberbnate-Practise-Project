package com.navtech.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navtech.dto.CertificateDTO;
import com.navtech.dto.models.CertificateDTOModel;
import com.navtech.models.Certificate;
import com.navtech.service.CertificateService;

@Component
public class CertificateDTOImpl implements CertificateDTO {
	
	@Autowired
	private CertificateService certificateService;

	@Override
	public CertificateDTOModel addCertificate(CertificateDTOModel certificateDTOModel) {
		Certificate certificate = this.createCertificatefromCertificateDTOModel(certificateDTOModel);
		certificate = this.certificateService.addCertificate(certificate);
		if(certificate != null) {
			return this.createCertificateDTOModelFromCertificate(certificate);
		} else {
			return null;
		}
	}

	private Certificate createCertificatefromCertificateDTOModel(CertificateDTOModel certificateDTOModel) {
		Certificate certificate = new Certificate();
		certificate.setCertificateTitle(certificateDTOModel.getCertificateTitle());
		certificate.setCertificateDescription(certificateDTOModel.getCertificateDescription());
		certificate.setCertificateId(certificateDTOModel.getCertificateId() + certificate.hashCode());
		return certificate;
	}
	
	private CertificateDTOModel createCertificateDTOModelFromCertificate(Certificate certificate) {
		CertificateDTOModel certificateDTOModel = new CertificateDTOModel();
		certificateDTOModel.setCertificateId(certificate.getCertificateId());
		certificateDTOModel.setCertificateTitle(certificate.getCertificateTitle());
		certificateDTOModel.setCertificateDescription(certificate.getCertificateDescription());
		return certificateDTOModel;
	}

	@Override
	public List<CertificateDTOModel> getCertificateDTOModelList() {
		List<Certificate> certificateList = this.certificateService.getCertificateList();
		return this.createCertificateDTOModelList(certificateList);
	}

	private List<CertificateDTOModel> createCertificateDTOModelList(List<Certificate> certificateList) {
		List<CertificateDTOModel> certificateDTOModels = new ArrayList<CertificateDTOModel>();
		for(Certificate certificateObj: certificateList) {
			certificateDTOModels.add(this.createCertificateDTOModelFromCertificate(certificateObj));
		}
		return certificateDTOModels;
	}

	@Override
	public String deleteCertificate(String certificateId) {
		return this.certificateService.deleteCertificate(certificateId);
	}

}
