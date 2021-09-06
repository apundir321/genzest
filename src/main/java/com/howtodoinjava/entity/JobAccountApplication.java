package com.howtodoinjava.entity;

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

import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.User;

@Entity
public class JobAccountApplication {


	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date applicationDate;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id")
	private JobAccount job;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id")
	private User applicant;
	
	private String checkinTime;
	
	
	private String checkoutTime;
	
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public JobAccount getJob() {
		return job;
	}
	public void setJob(JobAccount job) {
		this.job = job;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	
}
