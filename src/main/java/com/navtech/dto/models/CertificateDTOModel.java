package com.navtech.dto.models;

public class CertificateDTOModel {
	
	private String certificateId;
	private String certificateTitle;
	private String certificateDescription;
	
	/* Default Constructor */
	public CertificateDTOModel() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */
	public CertificateDTOModel(String certificateId, 
			String certificateTitle, String certificateDescription) {
		this.certificateId = certificateId;
		this.certificateTitle = certificateTitle;
		this.certificateDescription = certificateDescription;
	}
	
	/* Getter / Setter */
	
	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateTitle() {
		return certificateTitle;
	}

	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}

	public String getCertificateDescription() {
		return certificateDescription;
	}

	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}
	
	
}
