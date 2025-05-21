package com.app.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crm.enums.LoanStatus;
import com.app.crm.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByCustomerId(int customerId);
	public Customer findByCustomerEmailAndPassword(String customerEmail, String password);
	public Customer findByloanStatus(LoanStatus loanStatus);
	
	
}
