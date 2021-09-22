package com.howtodoinjava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	private String upiId;
	
	private String bankName;
	
	private String accountName;
	
	private String ifscCode;

	
	@OneToOne(mappedBy = "studentDocuments")
    private UserProfile userProfile;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
