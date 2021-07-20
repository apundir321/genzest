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
	
	@NotNull
	@NotEmpty(message = "Please enter first name")
	private String firstName;
	
	@NotNull
	@NotEmpty(message = "Please enter last name")
	private String lastName;
	
	@NotNull
	@NotEmpty(message = "Please enter email")
	@Email
	private String email;
	
	@NotNull
	@NotEmpty(message = "Please Enter Parents Name")
	private String parentsName;
	
	@NotNull
	@NotEmpty(message = "Mobile no. can't be empty")
	private String mobileNo;
	
	@NotNull
	@NotEmpty(message = "Please Enter Alternate Mobile No.")
	private String alternateMobileNo;
	
	@NotNull
	@NotEmpty(message = "Please select Gender")
	private String gender;
	
	@NotNull(message = "Please select DOB")
	@Past
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	public Date dob;
	
	@NotNull
	@NotEmpty(message = "Please Select Course")
	public String course;
	
	@NotNull
	@NotEmpty(message = "Please Select Vehicle Type")
	public String vehicleType;
	@NotNull
	@NotEmpty(message = "Please Select Blood Group")
	private String bloodGroup;
//	@NotEmpty(message = "Please Upload Adhar card photo")
	private String aadharFileName;
//	@NotEmpty(message = "Please Upload Student Id")
	private String studentIdFileName;
	private String profilePicFileName;
	private String status;
//	
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "organization_id")
//	private Organization organization;	
	
	
//	@Transient
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
////	@NotNull(message = "Please select category")
//	@JoinColumn(name = "category_id")
//	private Category category;
	
	
	@NotNull
	@NotEmpty(message = "Please Enter Address.")
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String streetNo;
	
	@NotNull
	@NotEmpty(message = "Please Enter Locality.")
	private String locality;
	private String landmark;
//	private String country;
	@NotNull
	@NotEmpty(message = "Please Enter Postal Code")
	private String postalCode;
	
	@NotNull
	@NotEmpty(message = "Please Enter College Name")
	private String collegeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@NotNull(message = "Please select Date")
	private Date degreeCollegeCompletionDate;
	@NotNull
	@NotEmpty(message = "Please Enter State.")
	private String state;
	@NotNull
	@NotEmpty(message = "Please Enter City.")
	private String city;
	
	@NotNull(message = "Please select value")
	private boolean havePc;
	
	@NotNull
	@NotEmpty(message = "Please select preference.")
	private String preference;
	private String paymentMethod;
	private String day;
	private String timeSlot;
	private Date lastUpdated;
//	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profile_category", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	public List<Category> jobCategories; 
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "profile_preference", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "preference_id") })
	private Set<DayPreference> preferences = new HashSet<>();
	
	
	public UserProfile() {
		super();
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAlternateMobileNo() {
		return alternateMobileNo;
	}
	public void setAlternateMobileNo(String alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Date getDegreeCollegeCompletionDate() {
		return degreeCollegeCompletionDate;
	}
	public void setDegreeCollegeCompletionDate(Date degreeCollegeCompletionDate) {
		this.degreeCollegeCompletionDate = degreeCollegeCompletionDate;
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
	public boolean isHavePc() {
		return havePc;
	}
	public void setHavePc(boolean havePc) {
		this.havePc = havePc;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	public Set<DayPreference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<DayPreference> preferences) {
		this.preferences = preferences;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfilePicFileName() {
		return profilePicFileName;
	}

	public void setProfilePicFileName(String profilePicFileName) {
		this.profilePicFileName = profilePicFileName;
	}
//
	public List<Category> getJobCategories() {
		return jobCategories;
	}

	public void setJobCategories(List<Category> categories) {
		this.jobCategories = categories;
	}

	

	
	
	

}
