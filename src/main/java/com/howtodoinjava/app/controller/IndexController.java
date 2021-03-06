package com.howtodoinjava.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.TimeSlot;
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
    private ApplicationEventPublisher eventPublisher;
    
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private ISecurityUserService securityService;
	

	@RequestMapping("/student-d.html")
	public String home(Map<String, Object> model) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		List<JobAccountApplication> appliedJobs = jobAccountApplicationRepo.findAllByApplicant(userRepo.findByEmail(authentication.getName()));
		model.put("appliedJobsCount", appliedJobs.size());
		List<JobAccount> matchingJobs = jobAccountCustomRepo.findJobsByCategory(null);
		model.put("matchingJobsCount", matchingJobs.size());
		model.put("user", session.getAttribute("user"));
		return "student-d";
	}
	
	
	@RequestMapping("/index.html")
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
		model.put("dayPreference",new DayPreference());
		model.put("timeSlotsCount", timeSlotRepo.count());
		model.put("studentCount", userProfileRepo.count());
		model.put("jobsCount", jobAccountRepo.count());
		model.put("jobTypeCount", jobTypeRepo.count());
		List<Object[]> categoryJobs = jobAccountCustomRepo.findJobAcountByCateory();
		
		List<CategoryCount> counts = new ArrayList<>();
		for(Object[] obj : categoryJobs)
		{
			CategoryCount count = new CategoryCount();
			Category cat = (Category) obj[0];
			count.category = cat.getCategoryName();
			count.value = (Long)obj[1];
			counts.add(count);
		}
		
		model.put("categoriesCountJobs", counts);
		return "index";
	}
	


	@RequestMapping("/profile.html")
	public String profile(Map<String, Object> model) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		model.put("profile", user.getUserProfile());
		return "profile";
	}

	@RequestMapping("/edit.html")
	public String edit(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		UserProfile profile = null;
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		try {
			Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
			User user = (User) userRepo.findByEmail(authentication.getName());
			model.put("user", user);
			profile = user.getUserProfile();
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			System.out.println(profile + "  *****");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("profile", profile==null?new UserProfile():profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("dayPreference",new DayPreference());
		model.put("timeSlots", timeSlotRepo.findAll());
		return "edit";
	}
	
	
	@RequestMapping("/showCandidateProfile")
	public String edit(Map<String, Object> model,@RequestParam String profileId) {
		model.put("message", "HowToDoInJava Reader !!");
		UserProfile profile = null;
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		try {
			Optional<UserProfile> profileEntity = userProfileRepo.findById(Integer.parseInt(profileId));
			profile = profileEntity.get(); 
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			System.out.println(profile + "  *****");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		model.put("profile", profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		return "admin/showCandidate";
	}



	@RequestMapping("/searchjobs.html")
	public String searchjobs(Map<String, Object> model) {
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<JobAccount> jobs = new ArrayList<JobAccount>();
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		List<Integer> appliedJobIds = new ArrayList<>();
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			jobTypes = jobTypeRepo.findAll();
			timeSlots = timeSlotRepo.findAll();
			List<JobAccount>  jobsAccount = jobAccountCustomRepo.findJobsByCategory(null);
			
			List<JobAccountApplication> jobApplications = jobAccountApplicationRepo.findAllByApplicant(user);
			for(JobAccountApplication accountApplication : jobApplications)
			{
				appliedJobIds.add(accountApplication.getJob().getId());
			}			
			
			for(JobAccount jobAccount : jobsAccount)
			{
				if(!appliedJobIds.contains(jobAccount.getId()))
				{
					jobs.add(jobAccount);
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
		model.put("jobs", jobs);
		model.put("searchJob", new SearchJobs());
		return "searchjobs";
	}

	@RequestMapping("/signup.html")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		model.put("userDto",new UserDto());
		return "signup";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup.html")
	public String submit(HttpServletRequest request,HttpServletResponse response,@Valid @ModelAttribute("userDto") UserDto userDto,BindingResult result, Map<String, Object> model,HttpSession session)
			throws Exception {
		User registered = null;
		if(result.hasErrors())	
		{
			return "signup";
		}

		
		boolean isRecruiter = request.getParameter("recruiter")==null?false:true;

		try {
			registered = uService.registerNewUserAccount(userDto,isRecruiter);	
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
			model.put("successMessage", "User registered");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("errorMessage", e.getMessage());
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
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			jobTypes = jobTypeRepo.findAll();
			timeSlots = timeSlotRepo.findAll(); 
			
			List<JobAccount>  jobsAccount = jobAccountCustomRepo.findJobsByJobCriterias(searchJob);
			
			List<JobAccountApplication> jobApplications = jobAccountApplicationRepo.findAllByApplicant(user);
			for(JobAccountApplication accountApplication : jobApplications)
			{
				appliedJobIds.add(accountApplication.getJob().getId());
			}			
			
			for(JobAccount jobAccount : jobsAccount)
			{
				if(!appliedJobIds.contains(jobAccount.getId()))
				{
					jobs.add(jobAccount);
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
		model.put("dayPreference",new DayPreference());
		model.put("jobs",jobs);
		model.put("searchJob", new SearchJobs());
		return "searchjobs";
	}
	


	@RequestMapping(method = RequestMethod.POST, value = "/updateProfile.html")
	public String searchJobs(@Valid @ModelAttribute("profile") UserProfile userProfile, BindingResult result,
			@RequestParam("aadhar") MultipartFile multipartFile,
			@RequestParam("studentId") MultipartFile studentIdMultipart,
			@RequestParam("profilepic") MultipartFile profilePicMultipart,Map<String, Object> model,
			@RequestParam(required = false) String userProfileId) throws Exception {
		
		UserProfile profile;
		model.put("dayPreference", new DayPreference());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("categories", categoryRepo.findAll());
		model.put("dayPreference",new DayPreference());
		model.put("timeSlots", timeSlotRepo.findAll());
		model.put("courses", courseRepo.findAll());
		if (userProfileId != null) {
			profile = userService.getUserProfile(userProfileId);
			if (profile != null) {
				model.put("profile", profile);
			}
		} else {
			
			if (result.hasErrors()) {
				return "edit";
			}
		
			Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
			
			if (!StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
				awsService.uploadFile(multipartFile, userProfile);
				userProfile.setAadharFileName(multipartFile.getOriginalFilename());
			}
			
			

			if (!StringUtils.isEmpty(studentIdMultipart.getOriginalFilename())) {
				awsService.uploadFile(studentIdMultipart, userProfile);
				userProfile.setStudentIdFileName(studentIdMultipart.getOriginalFilename());
			}
			
			if (!StringUtils.isEmpty(profilePicMultipart.getOriginalFilename())) {
				awsService.uploadFile(profilePicMultipart, userProfile);
				userProfile.setProfilePicFileName(profilePicMultipart.getOriginalFilename());
			}
			
			
			User user = userRepo.findByEmail(authentication.getName());
			model.put("user", user);
			userProfile.setLastUpdated(new Date());
			user.setUserProfile(userProfile);
			userRepo.save(user);
			model.put("successMessage", "Profile Updated!");
			model.put("profile", userProfile);
		}
		return "edit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updatePreferences.html")
	public void searchJobs(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("dayPreference") DayPreference dayPreference,Map<String, Object> model) throws Exception {
		System.out.println("***********88(((((((((((9");
		DayPreference preference = null;
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		UserProfile profile = userRepo.findByEmail(authentication.getName()).getUserProfile();
		Set<DayPreference> preferences = profile.getPreferences();
		
		for(DayPreference pref : preferences)
		{
			if(pref.getDay().equals(dayPreference.getDay()))
			{
				preference = pref;
				pref.setTimeSlot(dayPreference.getTimeSlot());
			}
		}
		
		if(preference==null)
		{
			profile.getPreferences().add(dayPreference);
			userProfileRepo.save(profile);
		}else
		{
			profile.setPreferences(preferences);
			userProfileRepo.save(profile);
		}
		
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		
		response.sendRedirect("/edit.html");
	}
	
	
	
	
	@RequestMapping("/applyJob")
	public String applyJob(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
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
				User user = (User) session.getAttribute("user");
				model.put("user", user);
				jobAccountApplication.setApplicant(user);
				jobAccountApplicationRepo.save(jobAccountApplication);
			}

		}
		model.put("successMessage", "Jobs Applied!"); 
		List<JobAccountApplication> applications = jobAccountApplicationRepo.findAllByApplicant((User)model.get("user"));
		model.put("applications", applications);
		return "appliedjobs";
	}
	
	@RequestMapping("/login.html")
	public String login() throws IOException {
		
		return "login";
	}
	
	@RequestMapping("/appliedjobs.html")
	public String appliedjobs(Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.put("message", "HowToDoInJava Reader !!");
		
		
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		List<JobAccountApplication> applications = jobAccountApplicationRepo.findAllByApplicant(user);
		model.put("applications", applications);
		return "appliedjobs";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "login1";  
     }  
	
	@GetMapping("/getProfilePic/{name}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String name) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getName()+"  &&&&&&7");
		User user = (User) session.getAttribute("user");
		ByteArrayOutputStream downloadInputStream = awsService.downloadFile(name,user.getUserProfile());
	
		return ResponseEntity.ok()
					.contentType(MediaType.IMAGE_PNG)
					.body(downloadInputStream.toByteArray());	
	}
	
	
	 private String getAppUrl(HttpServletRequest request) {
	        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	    }
	
	 
	    @GetMapping("/registrationConfirm.html")
	    public String confirmRegistration(final HttpServletRequest request, final ModelMap model, @RequestParam("token") final String token) throws UnsupportedEncodingException {
	        Locale locale = request.getLocale();
	        model.addAttribute("lang", locale.getLanguage());
	        final String result = iUserService.validateVerificationToken(token);
	        if (result.equals("valid")) {
	            final User user = iUserService.getUser(token);
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
	    public void resetPassword(final HttpServletRequest request,HttpServletResponse response, @RequestParam("email") final String userEmail,final ModelMap model,HttpSession session) throws IOException {
	        final User user = iUserService.findUserByEmail(userEmail);
	        try {
	        	
	       
	        if (user != null) {
	            final String token = UUID.randomUUID().toString();
	            iUserService.createPasswordResetTokenForUser(user, token);
	            mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
	            session.setAttribute("successMessage", "Forgot password link has been sent to your email id");
	        }
	        else
	        {
	        	 session.setAttribute("errorMessage", "No username has been found by this id");
	        }
	        }catch (Exception e) {
				// TODO: handle exception
	        	 session.setAttribute("errorMessage", "Exception occured with message="+e.getMessage());
			}
	        response.sendRedirect("/login.html");
	    }
	    
	    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final User user) {
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
	        if(result != null) {	          
	            model.addAttribute("errorMessage", "Invalid password token!");
	            return "login";
	        } else {
	            model.addAttribute("token", token);
	            ForgotPasswordDto forgotPasswordDto = new ForgotPasswordDto();
	            forgotPasswordDto.setToken(token);
	            model.addAttribute("forgotPasswordDto",forgotPasswordDto );
	            return "updateForgotpassword";
	        }
	    }
	    
	@RequestMapping(method = RequestMethod.POST, value = "/user/savePassword")
	public void savePassword(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("forgotPasswordDto") ForgotPasswordDto forgotPasswordDto, ModelMap model,HttpSession session) throws IOException {

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
	        HttpSession session = request.getSession(false);
	        String errorMessage = null;
	        if (session != null) {
	            AuthenticationException ex = (AuthenticationException) session
	                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	            if (ex != null) {
	                errorMessage = ex.getMessage();
	            }
	        }
	        model.addAttribute("errorMessage", errorMessage);
	        return "login";
	    }
	  
	  @GetMapping("/withdraw/appliedJob")
	  public void withdrawAppliedJob(HttpServletRequest request,HttpServletResponse res, ModelMap model,@RequestParam String jobId) throws IOException {
			try {
			Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
			User user = (User) userRepo.findByEmail(authentication.getName());
			Optional<JobAccount> jobAccount = jobAccountRepo.findById(Integer.parseInt(jobId));
//			model.put("user", user);
			jobAccountApplicationRepo.deleteAppliedJob(user, jobAccount.get());
			}catch (Exception e) {
				session.setAttribute("errorMessage", "Exception in withdrawing appliedjobs with error message="+e.getMessage());
				res.sendRedirect("/appliedjobs.html");
			}
			session.setAttribute("successMessage", "Successfully Withdrawed");
			res.sendRedirect("/appliedjobs.html");
	    }
	  
		    

	
	 
	
	
	

}