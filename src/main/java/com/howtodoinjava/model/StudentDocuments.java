package com.howtodoinjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDocuments {
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public StudentDocuments()
	{
		super();
	}
	
	private String aadharFileName;
	
	private String studentIdFileName;
	
	private String paymentMethod;
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getAadharFileName() {
		return aadharFileName;
	}

	public void setAadharFileName(String aadharFileName) {
		this.aadharFileName = aadharFileName;
	}

	public String getStudentIdFileName() {
		return studentIdFileName;
	}

	public void setStudentIdFileName(String studentIdFileName) {
		this.studentIdFileName = studentIdFileName;
	}

}
