package com.app.crm.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CustomerDto {

	private String message;
	private LocalDateTime dateTime;
	private String url;
	private HttpStatus httpStatus;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public CustomerDto(String message, LocalDateTime dateTime, String url, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.dateTime = dateTime;
		this.url = url;
		this.httpStatus = httpStatus;
	}
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
