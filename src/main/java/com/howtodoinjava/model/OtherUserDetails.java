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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.DayPreference;

@Entity
public class OtherUserDetails {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "otherDetails",orphanRemoval = true)
	private UserProfile userProfile;
	
public OtherUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	//	@NotNull
//	@NotEmpty(message = "Mobile no. can't be empty")
	private String mobileNo;
	
//	@NotNull
//	@NotEmpty(message = "Please Enter Alternate Mobile No.")
	private String alternateMobileNo;
	

	private String specialization;
	
//	@NotNull
//	@NotEmpty(message = "Please Select Course")
	public String course;
	
//	@NotNull
//	@NotEmpty(message = "Please Select Vehicle Type")
	public String vehicleType;

//	@NotEmpty(message = "Please Upload Adhar card photo")
	
//	@NotEmpty(message = "Please Upload Student Id")
	
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
	
	
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String streetNo;
	
//	@NotNull
//	@NotEmpty(message = "Please Enter Locality.")
	private String locality;
	private String landmark;
	private String country;
//	@NotNull
//	@NotEmpty(message = "Please Enter Postal Code")
	private String postalCode;
	
//	@NotNull
//	@NotEmpty(message = "Please Enter College Name")
	private String collegeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "Please select Date")
	private Date degreeCollegeCompletionDate;
//	@NotNull
//	@NotEmpty(message = "Please Enter State.")
	private String state;
//	@NotNull
//	@NotEmpty(message = "Please Enter City.")
	private String city;
	
//	@NotNull(message = "Please select value")
	private boolean havePc;
	
//	@NotNull
//	@NotEmpty(message = "Please select preference.")
	private String preference;
	
	private String day;
	private String timeSlot;
	private Date lastUpdated;
	
	private String referralCode;
//	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE, CascadeType.REFRESH  },orphanRemoval = true)
	@JoinTable(name = "profile_category", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	public List<Category> jobCategories; 
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE ,CascadeType.REFRESH },orphanRemoval = true)
	@JoinTable(name = "profile_preference", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "preference_id") })
	private Set<DayPreference> preferences = new HashSet<>();

	
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
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
	
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	public List<Category> getJobCategories() {
		return jobCategories;
	}

	public void setJobCategories(List<Category> categories) {
		this.jobCategories = categories;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public String getProfilePicFileName() {
		return profilePicFileName;
	}
	public void setProfilePicFileName(String profilePicFileName) {
		this.profilePicFileName = profilePicFileName;
	}
	public String getReferralCode() {
		return referralCode;
	}
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	
	
}
