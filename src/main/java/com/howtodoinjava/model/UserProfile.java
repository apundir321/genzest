package com.howtodoinjava.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.DayPreference;


@Entity
public class UserProfile {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@NotNull
	@NotEmpty(message = "Please enter first name")
	private String firstName;
	
//	@NotNull
	@NotEmpty(message = "Please enter last name")
	private String lastName;
	
//	@NotNull
	@NotEmpty(message = "Please enter email")
	@Email
	private String email;
	
	private String profilePicFileName;
	
//	@NotNull
//	@NotEmpty(message = "Please Enter Parents Name")
	private String parentsName;
	
//	@NotNull
//	@NotEmpty(message = "Please select Gender")
	private String gender;
	
//	@NotNull(message = "Please select DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date dob;
	
//	@NotNull
//	@NotEmpty(message = "Please Select Blood Group")
	private String bloodGroup;
	
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "otherdetails_id")
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private OtherUserDetails  otherDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_document_id", referencedColumnName = "id")
	private StudentDocuments studentDocuments;
	
	public String getProfilePicFileName() {
		return profilePicFileName;
	}

	public void setProfilePicFileName(String profilePicFileName) {
		this.profilePicFileName = profilePicFileName;
	}
	
	public OtherUserDetails getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(OtherUserDetails otherDetails) {
		this.otherDetails = otherDetails;
	}

	public UserProfile() {
		super();
	}
	
	public StudentDocuments getStudentDocuments() {
		return studentDocuments;
	}

	public void setStudentDocuments(StudentDocuments studentDocuments) {
		this.studentDocuments = studentDocuments;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParentsName() {
		return parentsName;
	}
	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
//	public Organization getOrganization() {
//		return organization;
//	}
//	public void setOrganization(Organization organization) {
//		this.organization = organization;
//	}
	

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	
	

	
	
	

}
