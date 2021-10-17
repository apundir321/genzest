package com.howtodoinjava.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class JobData {
	
	
	private String employer;
	
	
	private String jobName;
	
	
	private String category;
	
	
	private String jobType;
	
	
	
	private String noOfVacancy;
	
	private String vacancyForFemale;
	
	private String vacancyForMale;
	
	private String vacancyForOther;
	
	
	private String jobDate;
	
	  
	private String rate;
	
private String locality;
	
	private String description;
	
	private String jobCode;
	
	private String state;
	private String city;
	private String postalCode;
	
	private String createdDate;
	
	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getNoOfVacancy() {
		return noOfVacancy;
	}

	public void setNoOfVacancy(String noOfVacancy) {
		this.noOfVacancy = noOfVacancy;
	}

	public String getVacancyForFemale() {
		return vacancyForFemale;
	}

	public void setVacancyForFemale(String vacancyForFemale) {
		this.vacancyForFemale = vacancyForFemale;
	}

	public String getVacancyForMale() {
		return vacancyForMale;
	}

	public void setVacancyForMale(String vacancyForMale) {
		this.vacancyForMale = vacancyForMale;
	}

	public String getVacancyForOther() {
		return vacancyForOther;
	}

	public void setVacancyForOther(String vacancyForOther) {
		this.vacancyForOther = vacancyForOther;
	}

	public String getJobDate() {
		return jobDate;
	}

	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	

}
