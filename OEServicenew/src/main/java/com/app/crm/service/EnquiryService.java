package com.app.crm.service;

import java.util.List;

import com.app.crm.model.Enquiry;

public interface EnquiryService {

	List<Enquiry> getEnquiryByStatus(String enquirystatus);

}
