package com.app.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.crm.enums.LoanStatus;
import com.app.crm.model.Customer;
import com.app.crm.model.Enquiry;
import com.app.crm.service.CustomerService;
import com.app.crm.service.EnquiryService;

@CrossOrigin("*")
@RestController
public class CustomerController {


	@Autowired
	private CustomerService customerService;

	@Autowired
	private EnquiryService enquiryService;
	
	@Autowired
	RestTemplate rt;
	
	
	
	@GetMapping("/get_enquiry_byStatus/{enquirystatus}")
	public ResponseEntity<List<Enquiry>> getAllEnquiryByStatus(@PathVariable("enquirystatus")String enquirystatus)
	{
		List<Enquiry> enquiries=enquiryService.getEnquiryByStatus(enquirystatus);
		
		return new ResponseEntity<List<Enquiry>>(enquiries,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
public 	static int cibil=0;
	@GetMapping("/UpdateCibilStatus/{customerId}")
	public ResponseEntity<Integer> onSaveCustomerDetails(@PathVariable("customerId")int customerId) {
		
		
		String url="http://localhost:7076/generateCibil";
		 cibil=rt.getForObject(url, Integer.class);
		
		 System.out.println(cibil);
		 
		String url1="http://localhost:7070/forwordingtoOe/"+customerId;
		
		Enquiry enquiry=rt.getForObject(url1,Enquiry.class);
		System.out.println(enquiry);
		
		customerService.updateCibilScoreAndLoanStatusfindByloanStatus(enquiry);
		return new ResponseEntity<Integer>(enquiry.getCibil().getCibilScore(), HttpStatus.CREATED);
	}

	

	@GetMapping("documentverified/{customerId}")
	public ResponseEntity<String> verifiedDocument(@PathVariable("customerId")int customerId) 
	{
			String url="http://localhost:7073/getBycustomerId/"+customerId;
			Customer customer = rt.getForObject(url,Customer.class);
			customerService.loanStatus(customer);
			return new ResponseEntity<String>(customer.getLoanStatus().toString(),HttpStatus.OK);
	}
		
	
	
	
	
	
	
}
