package com.howtodoinjava.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.howtodoinjava.entity.JobAccount;

@Entity
public class JobEarning {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id")
	private JobAccount jobAccount;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id")
	private User applicantUser;
	
	private int totalHours;
	
	private int totalEarning;
	
	private int totalPaid;
	
	private Date presentDate; 
	
	private String status;
	
	private String payThrough;
	
	private String referenceNo;
	
	private String checkNo;
	
	private Date checkDate;

	public JobEarning() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobAccount getJobAccount() {
		return jobAccount;
	}

	public void setJobAccount(JobAccount jobAccount) {
		this.jobAccount = jobAccount;
	}

	public User getApplicantUser() {
		return applicantUser;
	}

	public void setApplicantUser(User applicantUser) {
		this.applicantUser = applicantUser;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getTotalEarning() {
		return totalEarning;
	}

	public void setTotalEarning(int totalEarning) {
		this.totalEarning = totalEarning;
	}

	public int getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Date getPresentDate() {
		return presentDate;
	}

	public void setPresentDate(Date presentDate) {
		this.presentDate = presentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayThrough() {
		return payThrough;
	}

	public void setPayThrough(String payThrough) {
		this.payThrough = payThrough;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	

}
