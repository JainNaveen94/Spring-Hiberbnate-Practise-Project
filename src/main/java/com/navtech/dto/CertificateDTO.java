package com.navtech.dto;

import java.util.List;

import com.navtech.dto.models.CertificateDTOModel;

public interface CertificateDTO {

	CertificateDTOModel addCertificate(CertificateDTOModel certificateDTOModel);

	List<CertificateDTOModel> getCertificateDTOModelList();

	String deleteCertificate(String certificateId);

}
