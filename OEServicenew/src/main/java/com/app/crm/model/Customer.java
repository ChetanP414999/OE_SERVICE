package com.app.crm.model;

import com.app.crm.enums.LoanStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private String customerDateOfBirth;
	private int customerAge;

	private String gender;
	
	private String pancardNo;
	private String adharCard;
	
	private String customerEmail;
	private String customerMobileNumber;
	
	private long customerAdditionalMobileNumber;
	private double customerAmmountPaidForCarloan;
	private double customerTotalLoanRequiredAmmount;
	private int loanTentureInMonth;
	
	private String userName;
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	private LoanStatus loanStatus;


	

	}
