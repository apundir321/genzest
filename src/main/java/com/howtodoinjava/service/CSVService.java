package com.howtodoinjava.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.hibernate.graph.spi.AppliedGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobAccountApplicationRepo;
import com.howtodoinjava.dao.JobEarningRepo;
import com.howtodoinjava.dao.UserProfileRepository;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.CourseRepo;
import com.howtodoinjava.domain.DayPreferenceRepo;
import com.howtodoinjava.domain.EmployerRepo;
import com.howtodoinjava.domain.JobAccountCustomRepo;
import com.howtodoinjava.domain.JobAccountRepo;
import com.howtodoinjava.domain.JobTypeRepo;
import com.howtodoinjava.domain.TimeSlotRepo;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.DayPreference;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.model.JobApplication;
import com.howtodoinjava.model.JobCategory;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;
import com.howtodoinjava.security.UserService;

@Service
public class CSVService {

	@Autowired
	JobAccountRepo repository;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	JobTypeRepo jobTypeRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	TimeSlotRepo timeSlotRepo;

	@Autowired
	EmployerRepo employerRepo;

	@Autowired
	JobAccountRepo jobAccountRepo;

	@Autowired
	UserProfileService userService;

	@Autowired
	JobEarningRepo jobEarningRepo;

	@Autowired
	UserService uService;

	@Autowired
	UserProfileRepository userProfileRepo;

	@Autowired
	JobAccountApplicationRepo jobAccountApplicationRepo;

	@Autowired
	DayPreferenceRepo dayPreferenceRepo;

	@Autowired
	JobAccountCustomRepo jobAccountCustomRepo;

	public ByteArrayInputStream load() {
		List<JobAccount> tutorials = repository.findAll();

		ByteArrayInputStream in = jobsToCSV(tutorials);
		return in;
	}

	public ByteArrayInputStream loadProfileData() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());

		ByteArrayInputStream in = profileToCSV((user.getUserProfile()));
		return in;
	}

	public ByteArrayInputStream loadAppliedJobsData() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		List<JobAccountApplication> applications = jobAccountApplicationRepo.findAllByApplicant(user);
		ByteArrayInputStream in = appliedJobsToCSV(applications);

		return in;
	}

	public ByteArrayInputStream loadProfilesData() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		List<UserProfile> applications = (List<UserProfile>) userProfileRepo.findAll();
		ByteArrayInputStream in = profilesToCSV(applications);
		return in;
	}
	
	public ByteArrayInputStream loadSelectedProfilesData(List<UserProfile> profiles) {
		
		ByteArrayInputStream in = profilesToCSV(profiles);
		return in;
	}


	public static ByteArrayInputStream jobsToCSV(List<JobAccount> jobAccounts) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			for (JobAccount jobAccount : jobAccounts) {
				List<String> data = Arrays.asList(jobAccount.getJobCode(), jobAccount.getEmployer().getEmployerName(),
						jobAccount.getTimeSlot() == null ? null : jobAccount.getTimeSlot().getTimeSlotName(),
						jobAccount.getCategory() == null ? null : jobAccount.getCategory().getCategoryName(),
						String.valueOf(jobAccount.getNoOfVacancy()), jobAccount.getCity(),
						dateFormat.format(jobAccount.getJobDate()), jobAccount.getStatus());

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream profileToCSV(UserProfile userProfile) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

			List<String> data = Arrays.asList(String.valueOf(userProfile.getId()), userProfile.getFirstName(),
					userProfile.getEmail(), userProfile.getOtherDetails().getMobileNo(),
					dateFormat.format(userProfile.getDob()), userProfile.getOtherDetails().getCourse(),
					userProfile.getOtherDetails().getCity(), userProfile.getOtherDetails().getState(),
					userProfile.getOtherDetails().getStatus());

			csvPrinter.printRecord(data);

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream profilesToCSV(List<UserProfile> userProfiles) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			List<String> headers = Arrays.asList("Id", "First Name", "Last Name", "Email", "Gender", "Parents Name",
					"Blood Group", "Date of birth", "Mobile No.", "Alternate Mobile No.", "Course", "City", "State",

					 "Vehicle Type", "Address Line1","Postal Code", "Have Pc",

					"College Name", "Landmark", "Locality", "Degree Completion Date", "Job Categories", "Preferences",
					"Referral Code", "Payment Method", "UPI Id", "Bank Name", "Account number", "IFSC code");
			csvPrinter.printRecord(headers);
			for (UserProfile userProfile : userProfiles) {

				String jobCategories = "";
				if (userProfile.getOtherDetails() != null) {
					if (userProfile.getOtherDetails().getJobCategories() != null) {
						List<Category> categories = userProfile.getOtherDetails().getJobCategories();
						for (Category category : categories) {
							jobCategories += category.getCategoryName() + ",";
						}

					}
				}

				String preferences = "";
				String degreeCompletionDate = "degreeCompletionDate not defined";
				if (userProfile.getOtherDetails() != null) {
					if (userProfile.getOtherDetails().getPreferences() != null) {
						Set<DayPreference> prefs = userProfile.getOtherDetails().getPreferences();
						for (DayPreference pref : prefs) {
							if (pref.getTimeSlot() != null && pref.getDay() != null) {
								preferences += pref.getDay() + "=" + pref.getTimeSlot() == null ? "TImeslot Not defined"
										: pref.getTimeSlot().getTimeSlotName() + ",";
							}
						}

					}

					if (userProfile.getOtherDetails().getDegreeCollegeCompletionDate() != null) {
						degreeCompletionDate = dateFormat
								.format(userProfile.getOtherDetails().getDegreeCollegeCompletionDate());
					}
				}

				List<String> data = Arrays.asList(String.valueOf(userProfile.getId()), userProfile.getFirstName(),
						userProfile.getLastName(), userProfile.getEmail(), userProfile.getGender(),
						userProfile.getParentsName(), userProfile.getBloodGroup(),
						userProfile.getDob() == null ? "" : dateFormat.format(userProfile.getDob()),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getMobileNo(),
						userProfile.getOtherDetails() == null ? ""
								: userProfile.getOtherDetails().getAlternateMobileNo(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getCourse(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getCity(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getState(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getVehicleType(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getAddressLine1(),

						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getPostalCode(),
						userProfile.getOtherDetails() == null ? ""
								: String.valueOf(userProfile.getOtherDetails().isHavePc()),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getCollegeName(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getLandmark(),
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getLocality(),
						degreeCompletionDate, jobCategories, preferences,
						userProfile.getOtherDetails() == null ? "" : userProfile.getOtherDetails().getReferralCode(),
						userProfile.getStudentDocuments() == null ? ""
								: userProfile.getStudentDocuments().getPaymentMethod(),
						userProfile.getStudentDocuments() == null ? "" : userProfile.getStudentDocuments().getUpiId(),
						userProfile.getStudentDocuments() == null ? ""
								: userProfile.getStudentDocuments().getBankName(),
						userProfile.getStudentDocuments() == null ? ""
								: userProfile.getStudentDocuments().getAccountName(),
						userProfile.getStudentDocuments() == null ? ""
								: userProfile.getStudentDocuments().getIfscCode()
								
//								,
//						userProfile.getStudentDocuments() == null || userProfile.getStudentDocuments().getAadharFileName() == null ? ""
//								: "http://genzest.online/getProfilePic/" + userProfile.getStudentDocuments().getAadharFileName(),
//						userProfile.getStudentDocuments() == null || userProfile.getStudentDocuments().getStudentIdFileName() == null ? ""
//								: "http://genzest.online/getProfilePic/" + userProfile.getStudentDocuments().getStudentIdFileName()
//						,userProfile.getProfilePicFileName() == null?"" : "http://genzest.online/getProfilePic/" +userProfile.getProfilePicFileName()
				);

				csvPrinter.printRecord(data);

			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream appliedJobsToCSV(List<JobAccountApplication> jobApplications) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			for (JobAccountApplication jobApplication : jobApplications) {
				List<String> data = Arrays.asList(String.valueOf(jobApplication.getId()),
						jobApplication.getJob().getJobName(), jobApplication.getJob().getCategory().getCategoryName(),
						jobApplication.getJob().getTimeSlot() == null ? null
								: jobApplication.getJob().getTimeSlot().getTimeSlotName(),
						jobApplication.getApplicant().getEmail(), jobApplication.getApplicant().getPhoneNo(),
						dateFormat.format(jobApplication.getApplicationDate()));
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

}

