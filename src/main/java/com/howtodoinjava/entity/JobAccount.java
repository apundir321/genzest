package com.howtodoinjava.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.howtodoinjava.model.User;


@Entity
public class JobAccount {
	
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotNull(message = "Please select Employer")
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@NotEmpty(message = "Please Enter Job Name")
	private String jobName;
	
	@NotNull(message = "Please select Category")
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "jobtype_id")
	private JobType jobType;
	
	
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	@Min(value=1, message="must be atleaset one vacancy")  
	private int noOfVacancy;
	
	private int vacancyForFemale;
	
	private int vacancyForMale;
	
	private int vacancyForOther;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date effectiveFrom;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date effectiveTill;
	
	private Date jobDate;
	
	@Min(value=1, message="Invalid Rate")  
	private int rate;
	
	private String locality;
	
	private String description;
	
	private String jobCode;
	
	private String state;
	private String city;
	private String postalCode;
	
	private String day;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "slot_id")
	private TimeSlot timeSlot;
	
	
	private String status;
	private Date createdDate;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE })
	@JoinTable(name = "job_timeslot", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
			@JoinColumn(name = "slot_id") })
	private Set<TimeSlot> timeSlots = new HashSet<>();
	
	
	private String action;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getNoOfVacancy() {
		return noOfVacancy;
	}
	public void setNoOfVacancy(int noOfVacancy) {
		this.noOfVacancy = noOfVacancy;
	}
	public int getVacancyForFemale() {
		return vacancyForFemale;
	}
	public void setVacancyForFemale(int vacancyForFemale) {
		this.vacancyForFemale = vacancyForFemale;
	}
	public int getVacancyForMale() {
		return vacancyForMale;
	}
	public void setVacancyForMale(int vacancyForMale) {
		this.vacancyForMale = vacancyForMale;
	}
	public int getVacancyForOther() {
		return vacancyForOther;
	}
	public void setVacancyForOther(int vacancyForOther) {
		this.vacancyForOther = vacancyForOther;
	}
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public Date getEffectiveTill() {
		return effectiveTill;
	}
	public void setEffectiveTill(Date effectiveTill) {
		this.effectiveTill = effectiveTill;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@JsonIgnore
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public JobAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "JobAccount [id=" + id + ", employer=" + employer + ", jobName=" + jobName + ", category=" + category
				+ ", jobType=" + jobType + ", noOfVacancy=" + noOfVacancy + ", vacancyForFemale=" + vacancyForFemale
				+ ", vacancyForMale=" + vacancyForMale + ", vacancyForOther=" + vacancyForOther + ", effectiveFrom="
				+ effectiveFrom + ", effectiveTill=" + effectiveTill + ", jobDate=" + jobDate + ", rate=" + rate
				+ ", locality=" + locality + ", description=" + description + ", jobCode=" + jobCode + ", state="
				+ state + ", city=" + city + ", postalCode=" + postalCode + ", day=" + day + ", timeSlot=" + timeSlot
				+ ", status=" + status + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", timeSlots="
				+ timeSlots + ", action=" + action + "]";
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Date getJobDate() {
		return jobDate;
	}
	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}
	public Set<TimeSlot> getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(Set<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

}
