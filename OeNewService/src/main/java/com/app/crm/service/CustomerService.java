package com.app.crm.service;

import com.app.crm.enums.LoanStatus;
import com.app.crm.model.Customer;
import com.app.crm.model.Enquiry;

public interface CustomerService {
	
	
	//public Customer findByloanStatus(LoanStatus loanStatus);

	//public void updateCibilScoreAndLoanStatus(Customer customer);

	public  Enquiry updateCibilScoreAndLoanStatusfindByloanStatus(Enquiry enquiry);

	public void loanStatus(Customer customer);

	
	
	//Customer updateCibilScoreAndLoanStatusfindByloanStatus(Customer customer);
	
}
