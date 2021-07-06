package com.howtodoinjava.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchJobEarning {
	
	private String jobId;
	private String employerName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateTo;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
}
