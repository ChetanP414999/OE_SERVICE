package com.app.crm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crm.controller.CustomerController;
import com.app.crm.enums.CibilStatus;
import com.app.crm.enums.LoanStatus;
import com.app.crm.model.Customer;
import com.app.crm.model.Enquiry;
import com.app.crm.repository.CustomerRepository;
import com.app.crm.repository.EnquiryRepository;
import com.app.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EnquiryRepository enquiryRepository;
	
	
	@Override
	public Enquiry updateCibilScoreAndLoanStatusfindByloanStatus(Enquiry enquiry ) {
	
	
		
		if(CustomerController.cibil>700)
		{
			

			enquiry.getCibil().setCibilScore(CustomerController.cibil);
			System.out.println(enquiry.getCibil().getCibilScore());
			enquiry.getCibil().setCibilStatus(CibilStatus.GOOD);
			enquiry.setEnquiryStatus("Applicable_for_loan");
			enquiryRepository.save(enquiry);
			return enquiry;
			
		}
		else if(CustomerController.cibil>500 && CustomerController.cibil<700 )
		{
			
			
			
			enquiry.getCibil().setCibilScore(CustomerController.cibil);
			enquiry.getCibil().setCibilStatus(CibilStatus.AVERAGE);
			enquiry.setEnquiryStatus("Applicable_for_loan");

			enquiryRepository.save(enquiry);
			return enquiry;
			
		}
		else {
			
			enquiry.getCibil().setCibilScore(CustomerController.cibil);
			enquiry.getCibil().setCibilStatus(CibilStatus.POOR);
			enquiry.setEnquiryStatus("Not_Applicable");
			enquiryRepository.save(enquiry);
			return enquiry;
			
		}
		
		
		
	}


	@Override
	public void loanStatus(Customer customer) {
	
		customer.setLoanStatus(LoanStatus.docVerified);
		customerRepository.save(customer);
	}


}
