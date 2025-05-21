package com.app.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crm.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
	public List<Enquiry> findByEnquiryStatus(String enquiryStatus);

}
