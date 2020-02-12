
package com.navtech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navtech.dto.CertificateDTO;
import com.navtech.dto.ReviewDTO;
import com.navtech.dto.StudentDTO;
import com.navtech.dto.models.CertificateDTOModel;
import com.navtech.dto.models.ReviewDTOModel;
import com.navtech.dto.models.StudentDTOModel;

@RestController
@RequestMapping("/rest/v1/student")
public class StudentController {
	
	/* DTOs Used Inside the Student Controller */
	
	@Autowired
	public StudentDTO studentDto;
	
	@Autowired
	public CertificateDTO certificateDto;
	
	@Autowired
	ReviewDTO reviewDto;
	
	
	
	
	/* Student Related Hits Are Here */
	
	@PostMapping("/addStudent")
	public StudentDTOModel addStudent(@RequestBody StudentDTOModel studentdtomodel) {
		return this.studentDto.addStudent(studentdtomodel);
	}
	
	@PostMapping("/issueCertificateToStudent")
	public String issueCertificateToStudent(@RequestParam String certificateId,
				@RequestParam String username) {
		return this.studentDto.issueCertificateToStudent(certificateId, username);
	}
	
	@GetMapping("/certifiateList/{username}")
	public List<CertificateDTOModel> getCertificateListOfStudent(@PathVariable String username) {
		return this.studentDto.getCertificateListOfStudent(username);
	}
	
	/* Certificate Related Hits are Here */
	
	@PostMapping("/addCertificate")
	public CertificateDTOModel addCertificate(@RequestBody CertificateDTOModel certificateDTOModel) {
		return this.certificateDto.addCertificate(certificateDTOModel);
	}
	
	@GetMapping("/getCertificateList")
	public List<CertificateDTOModel> getCertificateDTOModelsList() {
		return this.certificateDto.getCertificateDTOModelList();
	}
	
	@DeleteMapping("/deleteCertificate/{certificateId}")
	public String deleteCertificate(@PathVariable String certificateId) {
		return this.certificateDto.deleteCertificate(certificateId);
	}
	
	/* Subjects Related Hits are here */ //
	
	
	
	
	
	/* Certificate Reviews Hits are Here */
	
	@PostMapping("/addReview/{certificateId}")
	public String addReview(@RequestBody ReviewDTOModel reviewDTOModel,@PathVariable String certificateId) {
		boolean result = this.reviewDto.addReview(reviewDTOModel, certificateId);
		if(result) {
			return "Review Added Successfully";
		}
		return "Review is not Added Successfully";
	}
}
