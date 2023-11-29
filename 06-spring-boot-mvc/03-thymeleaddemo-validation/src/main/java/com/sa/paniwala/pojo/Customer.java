package com.sa.paniwala.pojo;

import com.sa.paniwala.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message = "is required!")
	@Size(min = 1, message = "is required!")
	private String lastName = "";
	
	@Min(value = 0, message = "Value shall be greater than or equal to zero")
	@Max(value = 10, message = "Value shall be less than or equal to 10")
	@NotNull(message = "is a required!")
	private Integer freePasses = 0;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 charters or digits")
	private String postalCode;

	@CourseCode(value = "PANI")
	private String courseCode;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
}
