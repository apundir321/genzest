package com.howtodoinjava.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.howtodoinjava.OnRegistrationCompleteEvent;
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
import com.howtodoinjava.domain.OtherDetailsRepo;
import com.howtodoinjava.domain.TimeSlotRepo;
import com.howtodoinjava.dto.ForgotPasswordDto;
import com.howtodoinjava.dto.UserDto;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.CategoryCount;
import com.howtodoinjava.entity.CourseType;
import com.howtodoinjava.entity.DayPreference;
import com.howtodoinjava.entity.Employer;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.entity.MarkAttendence;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.TimeSlot;
import com.howtodoinjava.model.JobTimeSlot;
import com.howtodoinjava.model.OtherUserDetails;
import com.howtodoinjava.model.StudentDocuments;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;
import com.howtodoinjava.security.ISecurityUserService;
import com.howtodoinjava.security.IUserService;
import com.howtodoinjava.security.UserService;
import com.howtodoinjava.service.AWSS3Service;
import com.howtodoinjava.service.UserProfileService;



@Controller
public class IndexController {

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	HttpSession session;

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
	IUserService iUserService;

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

	@Autowired
	AWSS3Service awsService;

	@Autowired
	OtherDetailsRepo otherUserDetailsRepo;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	@Autowired
	private ISecurityUserService securityService;
	
	 @Autowired
	 private MessageSource messages;

	@RequestMapping("/student-d.html")
	public String home(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		boolean isCompleteYouModal = false;
		if(user.getUserProfile().getParentsName()==null || user.getUserProfile().getParentsName().equals(""))
		{
			isCompleteYouModal = true;
		}
		
		model.put("isCompleteYouModal", isCompleteYouModal);
		List<JobAccountApplication> appliedJobs = jobAccountApplicationRepo.findAllByApplicant(user);
		model.put("appliedJobsCount", appliedJobs.size());
		List<String> userPreferenceList = new ArrayList<>();
		if(user.getUserProfile().getOtherDetails()!=null) {
		for(DayPreference preference :user.getUserProfile().getOtherDetails().getPreferences())
		{
			String pref = preference.getDay()+"_"+preference.getTimeSlot().getTimeSlotName();
			userPreferenceList.add(pref);
		}
		}
		OtherUserDetails otherDetails = user.getUserProfile().getOtherDetails();
		if (otherDetails != null) {
			List<JobAccount> matchingJobs = new ArrayList<>();
			
			for(JobAccount account : jobAccountCustomRepo.findJobsByCategories(otherDetails.getJobCategories()))
			{
				if(account.getStatus().equals("Open"))
				{
					if(userPreferenceList.size()>0)
					{
						boolean isJobMatchedWithUserPreference = false;
						for(TimeSlot timeSlot : account.getTimeSlots())
						{
							Calendar c = Calendar.getInstance();
					        c.setTime(account.getJobDate());
					        String dayWeekText = new SimpleDateFormat("EEEE").format(account.getJobDate());
					        String jobPrefence = dayWeekText+"_"+timeSlot.getTimeSlotName();
					        if(userPreferenceList.contains(jobPrefence))
					        {
					        	isJobMatchedWithUserPreference = true;
					        }
						}
						
						if(isJobMatchedWithUserPreference)
						{
							matchingJobs.add(account);
						}
						
						
					}else {
						matchingJobs.add(account);
					}
				}
			}
			model.put("matchingJobsCount", matchingJobs.size());
		} else {
			model.put("matchingJobsCount", "0");
		}
		model.put("user", session.getAttribute("user"));
		return "student-d";
	}

	@RequestMapping(value = {"/index.html","/"})
	public String index(Map<String, Object> model) {
//		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
//		System.out.println(authentication.getName()+"  &&&&&&7");
//		model.put("message", "HowToDoInJava Reader !!");
//		User user = userRepo.findByEmail(authentication.getName());
//		List<JobAccountApplication> appliedJobs = jobAccountApplicationRepo.findAllByApplicant(userRepo.findByEmail(authentication.getName()));
//		model.put("appliedJobsCount", appliedJobs.size());
//		List<JobAccount> matchingJobs = jobAccountCustomRepo.findJobsByCategory(user.getUserProfile().getCategory());
//		model.put("matchingJobsCount", matchingJobs.size());
		model.put("courseCount", courseRepo.count());
		model.put("employersCount", employerRepo.count());
		model.put("categoriesCount", categoryRepo.count());
		model.put("dayPreference", new DayPreference());
		model.put("timeSlotsCount", timeSlotRepo.count());
		model.put("studentCount", userProfileRepo.count());
		model.put("jobsCount", jobAccountRepo.count());
		model.put("jobTypeCount", jobTypeRepo.count());
		List<Object[]> categoryJobs = jobAccountCustomRepo.findJobAcountByCateory();

		List<CategoryCount> counts = new ArrayList<>();
		for (Object[] obj : categoryJobs) {
			CategoryCount count = new CategoryCount();
			Category cat = (Category) obj[0];
			count.category = cat.getCategoryName();
			count.value = (Long) obj[1];
			counts.add(count);
		}

		model.put("categoriesCountJobs", counts);
		return "index";
	}

	@RequestMapping("/profile.html")
	public String profile(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("profile", user.getUserProfile());
		OtherUserDetails userDetails = user.getUserProfile().getOtherDetails();
		if (userDetails == null) {
			model.put("otherDetails", new OtherUserDetails());
		} else {
			model.put("otherDetails", userDetails);
		}
		return "profile";
	}

	@RequestMapping("/edit.html")
	public String edit(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		UserProfile profile = null;
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		OtherUserDetails userDetails = null;
		List<JobType> jobTypes = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) userRepo.findByEmail(authentication.getName());
			model.put("user", user);
			profile = user.getUserProfile();
			courses = courseRepo.findByCourseTypeStatus("Active");
			employers = employerRepo.findAll();
			categories = categoryRepo.findByCategoryStatus("Active");
			jobTypes = jobTypeRepo.findByJobTypeStatus("Active");
			userDetails = profile.getOtherDetails();
			System.out.println(profile + "  *****");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		if (userDetails != null) {
			model.put("cities", categoryRepo.getCitiesByState(profile.getOtherDetails().getState()));
		}
		model.put("profile", profile == null ? new UserProfile() : profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findAll());
		model.put("jobTypes",jobTypes);
		if (userDetails == null) {
			model.put("otherDetails", new OtherUserDetails());
		} else {
			
			model.put("otherDetails", userDetails);
		}
		if (profile.getParentsName() == null) {
			model.put("editable", true);
		} else {
			model.put("editable", false);
		}
		StudentDocuments studentDocuments = profile.getStudentDocuments() == null ? new StudentDocuments()
				: profile.getStudentDocuments();
		model.put("studentDocs", studentDocuments);
		return "edit";
	}

	@RequestMapping("/showCandidateProfile")
	public String edit(Map<String, Object> model, @RequestParam String profileId) {
		model.put("message", "HowToDoInJava Reader !!");
		UserProfile profile = null;
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		try {
			Optional<UserProfile> profileEntity = userProfileRepo.findById(Integer.parseInt(profileId));
			profile = profileEntity.get();
			courses = courseRepo.findByCourseTypeStatus("Active");
			employers = employerRepo.findAll();
			categories = categoryRepo.findByCategoryStatus("Active");
			System.out.println(profile + "  *****");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		model.put("profile", profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		return "admin/showCandidate";
	}

	@RequestMapping("/searchjobs.html")
	public String searchjobs(Map<String, Object> model,@RequestParam(name = "matching",required = false) String matchingValue) {
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<JobAccount> matchingJobs = new ArrayList<>();
		List<JobAccount> jobs = new ArrayList<JobAccount>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		List<Integer> appliedJobIds = new ArrayList<>();
		try {
			courses = courseRepo.findByCourseTypeStatus("Active");
			employers = employerRepo.findAll();
			categories = categoryRepo.findByCategoryStatus("Active");
			jobTypes = jobTypeRepo.findByJobTypeStatus("Active");
			timeSlots = timeSlotRepo.findByTimeSlotStatus("Active");
			

			List<JobAccountApplication> jobApplications = jobAccountApplicationRepo.findAllByApplicant(user);
			for (JobAccountApplication accountApplication : jobApplications) {
				appliedJobIds.add(accountApplication.getJob().getId());
			}

//			for (JobAccount jobAccount : jobsAccount) {
//				if (!appliedJobIds.contains(jobAccount.getId())) {
//					if(jobAccount.getStatus()!=null && jobAccount.getStatus().equals("Open"))
//					{
//						jobs.add(jobAccount);
//					}
//					
//				}
//			}
			List<String> userPreferenceList = new ArrayList<>();
			if (user.getUserProfile().getOtherDetails() != null) {
				for (DayPreference preference : user.getUserProfile().getOtherDetails().getPreferences()) {
					String pref = preference.getDay() + "_" + preference.getTimeSlot().getTimeSlotName();
					userPreferenceList.add(pref);
				}
			}
			OtherUserDetails otherDetails = user.getUserProfile().getOtherDetails();
			if (otherDetails != null) {

				for (JobAccount account : jobAccountCustomRepo.findJobsByCategories(otherDetails.getJobCategories())) {
					if (account.getStatus().equals("Open")  && !appliedJobIds.contains(account.getId())) {
						if (userPreferenceList.size() > 0 && (matchingValue!=null && matchingValue.equals("true"))) {
							boolean isJobMatchedWithUserPreference = false;
							for (TimeSlot timeSlot : account.getTimeSlots()) {
								Calendar c = Calendar.getInstance();
								c.setTime(account.getJobDate());
								String dayWeekText = new SimpleDateFormat("EEEE").format(account.getJobDate());
								String jobPrefence = dayWeekText + "_" + timeSlot.getTimeSlotName();
								if (userPreferenceList.contains(jobPrefence)) {
									isJobMatchedWithUserPreference = true;
								}
							}

							if (isJobMatchedWithUserPreference) {
								matchingJobs.add(account);
							}

						} else {
							matchingJobs.add(account);
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("jobTypes", jobTypes);
		model.put("timeSlots", timeSlots);
		model.put("jobs", matchingJobs);
		model.put("searchJob", new SearchJobs());
		return "searchjobs";
	}

	@RequestMapping("/signup.html")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		model.put("userDto", new UserDto());
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signup.html")
	public String submit(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult result, Map<String, Object> model,
			HttpSession session) throws Exception {
		User registered = null;
		if (result.hasErrors()) {
			return "signup";
		}

		boolean isRecruiter = request.getParameter("recruiter") == null ? false : true;

		try {
			registered = uService.registerNewUserAccount(userDto, isRecruiter);
			eventPublisher
					.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
			model.put("successMessage", "User registered please verify your account on your registered email id");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("errorMessage", e.getMessage());
			model.put("userDto", userDto);
			return "signup";
		}
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/searchJobs.html")
	public String editJob(@ModelAttribute("searchJob") SearchJobs searchJob, Map<String, Object> model)
			throws Exception {
		System.out.println("***********88(((((((((((9");
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<JobAccount> jobs = new ArrayList<>();
		List<Integer> appliedJobIds = new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		try {
			courses = courseRepo.findByCourseTypeStatus("Active");
			employers = employerRepo.findAll();
			categories = categoryRepo.findByCategoryStatus("Active");
			jobTypes = jobTypeRepo.findByJobTypeStatus("Active");
			timeSlots = timeSlotRepo.findByTimeSlotStatus("Active");
			List<JobAccount> jobsAccount = jobAccountCustomRepo.findJobsByJobCriterias(searchJob);

			List<JobAccountApplication> jobApplications = jobAccountApplicationRepo.findAllByApplicant(user);
			for (JobAccountApplication accountApplication : jobApplications) {
				appliedJobIds.add(accountApplication.getJob().getId());
			}

			for (JobAccount jobAccount : jobsAccount) {
				if (!appliedJobIds.contains(jobAccount.getId())) {
					if(jobAccount.getStatus()!=null && jobAccount.getStatus().equals("Open"))
					{
						jobs.add(jobAccount);
					}
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("jobTypes", jobTypes);
		model.put("timeSlots", timeSlots);
		model.put("dayPreference", new DayPreference());
		model.put("jobs", jobs);
		model.put("searchJob", searchJob);
		return "searchjobs";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateProfile.html")
	public void updateProfile(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("profile") UserProfile userProfile, BindingResult result,

			@RequestParam("profilepic") MultipartFile profilePicMultipart, Map<String, Object> model,
			@RequestParam(required = false) String userProfileId) throws Exception {

		UserProfile profile;
		model.put("dayPreference", new DayPreference());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("categories", categoryRepo.findByCategoryStatus("Active"));
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findByTimeSlotStatus("Active"));
		model.put("courses", courseRepo.findByCourseTypeStatus("Active"));
		if (userProfileId != null) {
			profile = userService.getUserProfile(userProfileId);
			if (profile != null) {
				model.put("profile", profile);
			}
		} else {
//
//			if (result.hasErrors()) {
//				return "edit";
//			}

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userRepo.findByEmail(authentication.getName());
			UserProfile profileData = user.getUserProfile();

			profileData.setFirstName(userProfile.getFirstName());
			profileData.setLastName(userProfile.getLastName());
			profileData.setEmail(userProfile.getEmail());
			profileData.setParentsName(userProfile.getParentsName());
			profileData.setGender(userProfile.getGender());
			profileData.setDob(userProfile.getDob());
			profileData.setBloodGroup(userProfile.getBloodGroup());
			if (profileData.getParentsName() == null) {
				model.put("editable", true);
			} else {
				model.put("editable", false);
			}
			if (!StringUtils.isEmpty(profilePicMultipart.getOriginalFilename())) {
				
				String profilePicName = null;
				String extension = null;
				int i = profilePicMultipart.getOriginalFilename().lastIndexOf('.');
				if (i > 0) {
				    extension =  profilePicMultipart.getOriginalFilename().substring(i+1);
				    profilePicName = userProfile.getEmail()+"_"+userProfile.getId()+"."+extension;
				}else
				{
					profilePicName = profilePicMultipart.getOriginalFilename();
				}
				awsService.uploadFile(profilePicMultipart, user.getUserProfile(),profilePicName);
				profileData.setProfilePicFileName(profilePicName);
				
			}

			model.put("user", user);
			;
			user.setUserProfile(profileData);
			userRepo.save(user);
			model.put("successMessage", "Profile Updated!");
//			model.put("profile", profileData);
//			model.put("otherDetails", user.getUserProfile().getOtherDetails() == null ? new OtherUserDetails()
//					: user.getUserProfile().getOtherDetails());
//			model.put("studentDocs", user.getUserProfile().getStudentDocuments() == null ? new StudentDocuments()
//					: user.getUserProfile().getStudentDocuments());
		}
		session.setAttribute("successMessage", "Profile Updated!");
		response.sendRedirect("/edit.html");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateOtherDetails.html")
	public void updateOtherDetails(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("otherDetails") OtherUserDetails otherDetails, BindingResult result,
			Map<String, Object> model) throws Exception {

		UserProfile profile;
		model.put("dayPreference", new DayPreference());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("categories", categoryRepo.findByCategoryStatus("Active"));
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findByTimeSlotStatus("Active"));
		model.put("courses", courseRepo.findByCourseTypeStatus("Active"));
//		if (result.hasErrors()) {
//			return "edit";
//		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		otherDetails.setUserProfile(user.getUserProfile());
		OtherUserDetails savedUserDetails = user.getUserProfile().getOtherDetails();
		if (savedUserDetails != null) {
			otherDetails.setId(savedUserDetails.getId());
			otherDetails.setPreferences(savedUserDetails.getPreferences());
			UserProfile userProfile = user.getUserProfile();
			userProfile.setOtherDetails(otherDetails);
			userProfileRepo.save(userProfile);
		} else {
			UserProfile userProfile = user.getUserProfile();
			userProfile.setOtherDetails(otherDetails);
			userProfileRepo.save(userProfile);
		}
		session.setAttribute("successMessage", "Profile Updated!");
		response.sendRedirect("/edit.html");
//		model.put("successMessage", "Profile Updated!");
//		model.put("profile", user.getUserProfile());
//		model.put("otherDetails", otherDetails);
//		model.put("studentDocs", user.getUserProfile().getStudentDocuments() == null ? new StudentDocuments()
//				: user.getUserProfile().getStudentDocuments());
//		return "edit";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatedocs.html")
	public void updateDocs(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("studentDocs") StudentDocuments studentDocuments,
			@RequestParam("aadhar") MultipartFile multipartFile,
			@RequestParam("studentId") MultipartFile studentIdMultipart, BindingResult result,
			Map<String, Object> model) throws Exception {

		UserProfile profile;
		model.put("dayPreference", new DayPreference());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("categories", categoryRepo.findByCategoryStatus("Active"));
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findByTimeSlotStatus("Active"));
		model.put("courses", courseRepo.findByCourseTypeStatus("Active"));
//		if (result.hasErrors()) {
//			return "edit";
//		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		StudentDocuments savedStudentDocuments = user.getUserProfile().getStudentDocuments();
		if (savedStudentDocuments != null) {
			if (!StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
				String profilePicName = null;
				String extension = null;
				int i = multipartFile.getOriginalFilename().lastIndexOf('.');
				if (i > 0) {
				    extension =  multipartFile.getOriginalFilename().substring(i+1);
				    profilePicName = user.getUserProfile().getEmail()+"_"+user.getUserProfile().getId()+"_aadhar."+extension;
				}else
				{
					profilePicName = multipartFile.getOriginalFilename();
				}
				awsService.uploadFile(multipartFile, user.getUserProfile(),profilePicName);
				studentDocuments.setAadharFileName(profilePicName);
			} else {
				studentDocuments.setAadharFileName(savedStudentDocuments.getAadharFileName());

			}

			if (!StringUtils.isEmpty(studentIdMultipart.getOriginalFilename())) {
				
				String profilePicName = null;
				String extension = null;
				int i = studentIdMultipart.getOriginalFilename().lastIndexOf('.');
				if (i > 0) {
				    extension =  studentIdMultipart.getOriginalFilename().substring(i+1);
				    profilePicName = user.getUserProfile().getEmail()+"_"+user.getUserProfile().getId()+"_studentID."+extension;
				}else
				{
					profilePicName = studentIdMultipart.getOriginalFilename();
				}
				awsService.uploadFile(studentIdMultipart, user.getUserProfile(),profilePicName);
				studentDocuments.setStudentIdFileName(profilePicName);
			} else {

				studentDocuments.setStudentIdFileName(savedStudentDocuments.getStudentIdFileName());

			}

			model.put("user", user);
//			userProfile.setLastUpdated(new Date());
			UserProfile userprofile = user.getUserProfile();
			studentDocuments.setId(savedStudentDocuments.getId());
			userprofile.setStudentDocuments(studentDocuments);
			userProfileRepo.save(userprofile);
		}
		else
		{
			if (!StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
				String profilePicName = null;
				String extension = null;
				int i = multipartFile.getOriginalFilename().lastIndexOf('.');
				if (i > 0) {
				    extension =  multipartFile.getOriginalFilename().substring(i+1);
				    profilePicName = user.getUserProfile().getEmail()+"_"+user.getUserProfile().getId()+"_aadhar."+extension;
				}else
				{
					profilePicName = multipartFile.getOriginalFilename();
				}
				awsService.uploadFile(multipartFile, user.getUserProfile(),profilePicName);
				studentDocuments.setAadharFileName(profilePicName);
			} 

			if (!StringUtils.isEmpty(studentIdMultipart.getOriginalFilename())) {
				String profilePicName = null;
				String extension = null;
				int i = studentIdMultipart.getOriginalFilename().lastIndexOf('.');
				if (i > 0) {
				    extension =  studentIdMultipart.getOriginalFilename().substring(i+1);
				    profilePicName = user.getUserProfile().getEmail()+"_"+user.getUserProfile().getId()+"_studentID."+extension;
				}else
				{
					profilePicName = studentIdMultipart.getOriginalFilename();
				}
				awsService.uploadFile(studentIdMultipart, user.getUserProfile(),profilePicName);
				studentDocuments.setStudentIdFileName(profilePicName);
			} 

			model.put("user", user);
//			userProfile.setLastUpdated(new Date());
			UserProfile userprofile = user.getUserProfile();
			userprofile.setStudentDocuments(studentDocuments);
			userProfileRepo.save(userprofile);
		}
		session.setAttribute("successMessage", "Profile Updated!");
		response.sendRedirect("/edit.html");
//		model.put("profile", user.getUserProfile());
//		model.put("otherDetails",  user.getUserProfile().getOtherDetails() == null ? new OtherUserDetails()
//				: user.getUserProfile().getOtherDetails());
//		model.put("studentDocs", user.getUserProfile().getStudentDocuments());

	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatePreferences.html")
	public void searchJobs(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("dayPreference") DayPreference dayPreference, Map<String, Object> model) throws Exception {
		DayPreference preference = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserProfile profile = userRepo.findByEmail(authentication.getName()).getUserProfile();
		Set<DayPreference> preferences = null;
		OtherUserDetails otherUserDetails = profile.getOtherDetails();
		if (otherUserDetails != null) {
			preferences = profile.getOtherDetails().getPreferences();
		} else {
			otherUserDetails = new OtherUserDetails();
			preferences = new HashSet<>();
		}
		
		DayPreference savedPref = getPreference(preferences, dayPreference);
		
		if(savedPref != null)
		{
			if(!savedPref.getTimeSlot().getTimeSlotName().equals(dayPreference.getTimeSlot().getTimeSlotName()))
			{
				preferences.add(dayPreference);
				otherUserDetails.setPreferences(preferences);
				profile.setOtherDetails(otherUserDetails);
				userProfileRepo.save(profile);
				session.setAttribute("successMessage", "Profile Updated!");
				
			}else
			{
				session.setAttribute("errorMessage", "Time Slot already added!");
			}
		}
		else
		{
			preferences.add(dayPreference);
			otherUserDetails.setPreferences(preferences);
			profile.setOtherDetails(otherUserDetails);
			userProfileRepo.save(profile);
			session.setAttribute("successMessage", "Profile Updated!");
		}
		
		
//		for (DayPreference pref : preferences) {
//			if (pref.getDay().equals(dayPreference.getDay())  && pref.getTimeSlot().getTimeSlotName().equals(dayPreference.getTimeSlot().getTimeSlotName())) {
//				preference = pref;
//				pref.setTimeSlot(dayPreference.getTimeSlot());
//			}
//		}
//
//		if (preference == null) {
//			otherUserDetails.getPreferences().add(dayPreference);
//			profile.setOtherDetails(otherUserDetails);
//			userProfileRepo.save(profile);
//		} else {
//			otherUserDetails.setPreferences(preferences);
//			profile.setOtherDetails(otherUserDetails);
//			userProfileRepo.save(profile);
//		}
		
		

		
		response.sendRedirect("/edit.html");
	}
	
	
	public DayPreference getPreference(Set<DayPreference> preferences,DayPreference dayPreference)
	{
		DayPreference preference = null;
		for(DayPreference pref : preferences)
		{
			if (pref.getDay().equals(dayPreference.getDay()))
			{
				preference = pref;
			}
		}
		return preference;
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/deletePreference.html")
	public void deletePreferences(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String preferenceId) throws Exception {
		System.out.println("***********88(((((((((((9");
		DayPreference preference = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserProfile profile = userRepo.findByEmail(authentication.getName()).getUserProfile();
		Set<DayPreference> preferences = new HashSet<>();
		OtherUserDetails otherUserDetails = profile.getOtherDetails();
		if (otherUserDetails != null) {
			for(DayPreference prefer: profile.getOtherDetails().getPreferences())
			{
				if(prefer.getId()!=Integer.parseInt(preferenceId))
				{
					preferences.add(prefer);
				}
			}
			
			otherUserDetails.setPreferences(preferences);
			profile.setOtherDetails(otherUserDetails);
			userProfileRepo.save(profile);
			session.setAttribute("successMessage", "Timeslot Deleted!");
			
		}
		
		response.sendRedirect("/edit.html");
	}

	@RequestMapping("/applyJob")
	public void applyJob(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
			@RequestParam String jobId) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (jobId.contains(",")) {
			String[] jobIds = jobId.split(",");
			if (jobIds.length > 0) {
				for (String job : jobIds) {
					Optional<JobAccount> jobAccount = jobAccountRepo.findById(Integer.parseInt(job));
					if (jobAccount.isPresent()) {
						JobAccountApplication jobAccountApplication = new JobAccountApplication();
						jobAccountApplication.setJob(jobAccount.get());
						jobAccountApplication.setApplicationDate(new Date());
						jobAccountApplication.setStatus("OPEN");
						User user = userRepo.findByEmail(auth.getName());
						model.put("user", user);
						jobAccountApplication.setApplicant(user);
						jobAccountApplicationRepo.save(jobAccountApplication);
					}
				}
			}
		} else {
			Optional<JobAccount> jobAccount = jobAccountRepo.findById(Integer.parseInt(jobId));
			if (jobAccount.isPresent()) {
				JobAccountApplication jobAccountApplication = new JobAccountApplication();
				jobAccountApplication.setJob(jobAccount.get());
				jobAccountApplication.setApplicationDate(new Date());
				jobAccountApplication.setStatus("OPEN");
				User user = (User) session.getAttribute("user");
				model.put("user", user);
				jobAccountApplication.setApplicant(user);
				jobAccountApplicationRepo.save(jobAccountApplication);
			}

		}
		session.setAttribute("successMessage", "Jobs Applied!");
		List<JobAccountApplication> applications = jobAccountApplicationRepo
				.findAllByApplicant((User) model.get("user"));
		model.put("applications", applications);
		response.sendRedirect("/appliedjobs.html");
	}

	@RequestMapping("/login.html")
	public String login() throws IOException {

		return "login";
	}

	@RequestMapping("/appliedjobs.html")
	public String appliedjobs(Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.put("message", "HowToDoInJava Reader !!");
		User user = userRepo.findByEmail(auth.getName());
		model.put("user", user);

		List<JobAccountApplication> applications = new ArrayList<JobAccountApplication>();

		for (JobAccountApplication accountApplication : jobAccountApplicationRepo.findAllByApplicant(user)) {
			if (!accountApplication.getJob().getStatus().equals("Deleted")) {

				applications.add(accountApplication);
			}
		}
		model.put("applications", applications);
		return "appliedjobs";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login1";
	}

	@RequestMapping(value = "/markAttendence.html", method = RequestMethod.GET)
	public String markAttendence(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
			@RequestParam String applicationId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		model.put("applicationId", applicationId);
		model.put("markAttendence", new MarkAttendence());
		return "markattendence";
	}

	@RequestMapping(value = "/markAttendencePost.html", method = RequestMethod.POST)
	public void markAttendence(@ModelAttribute("markAttendence") MarkAttendence markAttendence,
			HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
//		String checkInTime = request.getParameter("checkinTime");
//		String checkoutTime = request.getParameter("checkoutTime");

		String checkInTime = markAttendence.getCheckinTime();
		String checkoutTime = markAttendence.getCheckoutTime();
		String applicationId = request.getParameter("applicationId");
		System.out.println(checkInTime);
		if (!StringUtils.isEmpty(checkInTime) && !StringUtils.isEmpty(checkoutTime)) {
			Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo
					.findById(Long.parseLong(applicationId));
			JobAccountApplication application = jobApplication.get();
			application.setCheckinTime(checkInTime);
			application.setCheckoutTime(checkoutTime);
			application.setStatus("MARKED");
			jobAccountApplicationRepo.save(application);
			session.setAttribute("successMessage", "Attendence Marked");
			response.sendRedirect("/appliedjobs.html");
		} else {
			session.setAttribute("errorMessage", "Input details invalid");
			response.sendRedirect("/markAttendence.html");
		}
	}

	@GetMapping("/getProfilePic/{name}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String name) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getName() + "  &&&&&&7");
		User user = userRepo.findByEmail(authentication.getName());
		ByteArrayOutputStream downloadInputStream = null;
		;
		try {
			downloadInputStream = awsService.downloadFile(name, user.getUserProfile());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(downloadInputStream.toByteArray());
	}
	
	@GetMapping("/getProfilePic/{name}/{userProfileId}")
	public ResponseEntity<byte[]> downloadFileByUserProfileId(@PathVariable String name,@PathVariable String userProfileId ) {
		
		ByteArrayOutputStream downloadInputStream = null;
		UserProfile profile = userProfileRepo.findById(Integer.parseInt(userProfileId)).get();
		try {
			downloadInputStream = awsService.downloadFile(name, profile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(downloadInputStream.toByteArray());
	}

	@RequestMapping("/viewjobs-genz.html")
	public String showUpdateJob(Map<String, Object> model, @RequestParam String jobId) {
		List<TimeSlot> timeSlots = timeSlotRepo.findByTimeSlotStatus("Active");
		List<Category> categories = categoryRepo.findByCategoryStatus("Active");
		List<Employer> employers = employerRepo.findAll();
		if (jobId != null) {
			Optional<JobAccount> jobAccountEntity = jobAccountRepo.findById(Integer.parseInt(jobId));
			if (jobAccountEntity.isPresent()) {
				model.put("jobAccount", jobAccountEntity.get());
			}
		} else {
			model.put("jobAccount", new JobAccount());
		}
		model.put("timeSlots", timeSlots);
		model.put("categories", categories);
		model.put("employers", employers);
		model.put("jobTimeSlot", new JobTimeSlot());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("user", user);
		return "viewjobs";
	}

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

	@GetMapping("/registrationConfirm.html")
	public String confirmRegistration(final HttpServletRequest request, final ModelMap model,
			@RequestParam("token") final String token) throws UnsupportedEncodingException {
		Locale locale = request.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		final String result = iUserService.validateVerificationToken(token);
		if (result.equals("valid")) {
			final User user = iUserService.getUser(token);

			user.setEnabled(true);
			userRepo.save(user);
			model.addAttribute("successMessage", "Account has been verified please log in now!");
			return "login";
		}
		model.addAttribute("errorMessage", "Token is Expired!");
		return "login";
	}

//	@RequestMapping(value="/logout", method=RequestMethod.GET)  
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
//        if (auth != null){      
//           new SecurityContextLogoutHandler().logout(request, response, auth);  
//        }  
//         return "login1";  
//     }  

	@RequestMapping("/forgotpassword")
	public String forgotpassword() throws IOException {

		return "forgotpassword";
	}

	@RequestMapping("/user/resetPassword")
	public void resetPassword(final HttpServletRequest request, HttpServletResponse response,
			@RequestParam("email") final String userEmail, final ModelMap model, HttpSession session)
			throws IOException {
		final User user = iUserService.findUserByEmail(userEmail);
		try {

			if (user != null) {
				final String token = UUID.randomUUID().toString();
				iUserService.createPasswordResetTokenForUser(user, token);
//				mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
				constructEmailMessage(getAppUrl(request), user, token);
				session.setAttribute("successMessage", "Forgot password link has been sent to your email id");
			} else {
				session.setAttribute("errorMessage", "No username has been found by this id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("errorMessage", "Exception occured with message=" + e.getMessage());
		}
		response.sendRedirect("/login.html");
	}

	private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final User user) {
		final String url = contextPath + "/user/changePassword?token=" + token;
		final String message = "Reset Password";
		return constructEmail("Reset Password", message + " \r\n" + url, user);
	}

	private SimpleMailMessage constructEmail(String subject, String body, User user) {
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	@GetMapping("/user/changePassword")
	public String showChangePasswordPage(final ModelMap model, @RequestParam("token") final String token) {
		final String result = securityService.validatePasswordResetToken(token);
		if (result != null) {
			model.addAttribute("errorMessage", "Invalid password token!");
			return "login";
		} else {
			model.addAttribute("token", token);
			ForgotPasswordDto forgotPasswordDto = new ForgotPasswordDto();
			forgotPasswordDto.setToken(token);
			model.addAttribute("forgotPasswordDto", forgotPasswordDto);
			return "updateForgotpassword";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/savePassword")
	public void savePassword(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("forgotPasswordDto") ForgotPasswordDto forgotPasswordDto, ModelMap model,
			HttpSession session) throws IOException {

		final String result = securityService.validatePasswordResetToken(forgotPasswordDto.getToken());

		if (result != null) {
			session.setAttribute("errorMessage", "Invalid Token Please verify your email again!");
			response.sendRedirect("/login.html");
		}

		Optional<User> user = iUserService.getUserByPasswordResetToken(forgotPasswordDto.getToken());
		if (user.isPresent()) {
			iUserService.changeUserPassword(user.get(), forgotPasswordDto.getNewPassword());
			session.setAttribute("successMessage",
					"Password has been updated please try login in with your updated password.");

		} else {
			session.setAttribute("errorMessage", "User is not present for this token!");

		}

		response.sendRedirect("/login.html");

	}

	@RequestMapping("/accessdenied")
	public String accessdenied() throws IOException {

		return "accessdenied";
	}

	@GetMapping("/login-error")
	public String login(HttpServletRequest request, Model model) {
		HttpSession sessionObj = request.getSession(false);
		String errorMessage = null;
		if (sessionObj != null) {
			AuthenticationException ex = (AuthenticationException) session
					.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (ex != null) {
				errorMessage = ex.getMessage();
			}
		}

		String errorMsg = (String) session.getAttribute("errorLoginMessage");

		model.addAttribute("errorMessage", errorMessage);
		if (errorMsg != null) {
			model.addAttribute("errorLoginMessage", errorMsg);
			model.addAttribute("errorMessage", null);
		}
		return "login";
	}

	@GetMapping("/withdraw/appliedJob")
	public void withdrawAppliedJob(HttpServletRequest request, HttpServletResponse res, ModelMap model,
			@RequestParam String jobId) throws IOException {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) userRepo.findByEmail(authentication.getName());
			Optional<JobAccount> jobAccount = jobAccountRepo.findById(Integer.parseInt(jobId));
//			model.put("user", user);
			jobAccountApplicationRepo.deleteAppliedJob(user, jobAccount.get());
		} catch (Exception e) {
			session.setAttribute("errorMessage",
					"Exception in withdrawing appliedjobs with error message=" + e.getMessage());
			res.sendRedirect("/appliedjobs.html");
		}
		session.setAttribute("successMessage", "Successfully Withdrawed");
		res.sendRedirect("/appliedjobs.html");
	}

	@RequestMapping("/error.html")
	public String error() throws IOException {

		return "error";
	}
	
	
	private void constructEmailMessage(final String appUrl, final User user, final String token) {
    	System.out.println("sending email");
    	final String recipientAddress = user.getEmail();
        final String subject = "Reset Password";
//        final String confirmationUrl = appUrl + "/registrationConfirm.html?token=" + token;
//        final String message = messages.getMessage("message.regSuccLink", null, "You registered successfully. To confirm your registration, please click on the below link.", event.getLocale());
        final String url = appUrl + "/user/changePassword?token=" + token;
		final String message = "Reset Password";
        
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + url);
        email.setFrom(env.getProperty("support.email"));
//        return email;
        List<String> sendList = Arrays.asList(recipientAddress);
////        sendMailViaGodaddy("support@genzest.com", "support@genzest", sendList, subject, message + " \r\n" + confirmationUrl);
        sendMailViaAws("support@genzest.com", "support@genzest", sendList, subject, message + " \r\n" + url);

    }
	
	
	 public  void sendMailViaAws(String from, String password,List<String> to,String subject,String text ) {
	        try {
	        	String SMTP_USERNAME = "AKIAR6ST375ZJTBO7IEQ";
	        	 String SMTP_PASSWORD = "BAyh53Fh4w6NQUF0o2ZRd6K8mKforvYGYZMUUAwdF4uF";
	        	 String HOST = "email-smtp.us-east-2.amazonaws.com";
	        	 int PORT = 587;
	        	System.out.println("sending email");
	          Properties props = System.getProperties();
	          props.setProperty("mail.transport.protocol", "smtp");
	          props.setProperty("mail.host", "smtpout.secureserver.net");
	          props.put("mail.smtp.port", PORT);
	 
	         props.put("mail.smtp.auth", "true");
//	         props.setProperty("mail.user", from);
//	         props.setProperty("mail.password", password);
	         
	        Session mailSession = Session.getDefaultInstance(props, null);
	        // mailSession.setDebug(true);
	        Transport transport = mailSession.getTransport("smtp");
	        MimeMessage message = new MimeMessage(mailSession);
	        message.setSentDate(new java.util.Date());
	        message.setSubject(subject);
	        message.setFrom(new InternetAddress(from));
	        for (int i=0;i < to.size();i++)
	        {
	                                         
	         message.addRecipient(Message.RecipientType.TO, new  
	          InternetAddress(to.get(i)));
	        }
	               
	        message.setText(text);
	 
	                        transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
	        transport.sendMessage(message,
	         message.getRecipients(Message.RecipientType.TO));
	        
	        System.out.println("email sent");
	        transport.close();
	                       
	         
	        } catch (Exception e) {
	        	System.out.println("exception occured");
	        }
	   }

}
