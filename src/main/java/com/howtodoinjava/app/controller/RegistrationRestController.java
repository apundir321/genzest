package com.howtodoinjava.app.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.OnRegistrationCompleteEvent;
import com.howtodoinjava.dao.JobAccountApplicationRepo;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.JobAccountCustomRepo;
import com.howtodoinjava.dto.PasswordDto;
import com.howtodoinjava.dto.UserDto;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.entity.JobData;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.error.InvalidOldPasswordException;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.VerificationToken;
import com.howtodoinjava.security.ISecurityUserService;
import com.howtodoinjava.security.IUserService;
import com.howtodoinjava.service.CSVService;
import com.howtodoinjava.util.GenericResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 36000)
public class RegistrationRestController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private ISecurityUserService securityUserService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private Environment env;
    
    @Autowired
	HttpSession session;
	
	@Autowired
	CSVService csvService;
	
	@Autowired
	JobAccountCustomRepo jobAccountCustomRepo;
	
	@Autowired
	JobAccountApplicationRepo jobAccountApplicationRepo;
    
    
    @Autowired
    private CategoryRepo categoryRepo;

    public RegistrationRestController() {
        super();
    }

    // Registration
    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@RequestBody @Valid final UserDto accountDto, final HttpServletRequest request) throws Exception {
        LOGGER.debug("Registering user account with information: {}", accountDto);
        boolean isRecruiter = request.getParameter("recruiter")==null?false:true;
        final User registered = userService.registerNewUserAccount(accountDto,isRecruiter);
//        userService.addUserLocation(registered, getClientIP(request));
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
        return new GenericResponse("success");
    }
    
    @PostMapping("/user/admin/registration")
    public GenericResponse registerAdmin(@RequestBody @Valid final UserDto accountDto, final HttpServletRequest request) throws Exception {
        LOGGER.debug("Registering user account with information: {}", accountDto);
        boolean isRecruiter = request.getParameter("recruiter")==null?false:true;
        final User registered = userService.registerAdminAccount(accountDto,isRecruiter);
//        userService.addUserLocation(registered, getClientIP(request));
      //  eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
        return new GenericResponse("success");
    }

    // User activation - verification
    @GetMapping("/user/resendRegistrationToken")
    public GenericResponse resendRegistrationToken(final HttpServletRequest request, @RequestParam("token") final String existingToken) {
        final VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
        final User user = userService.getUser(newToken.getToken());
//        mailSender.send(constructResendVerificationTokenEmail(getAppUrl(request), request.getLocale(), newToken, user));
        return new GenericResponse(messages.getMessage("message.resendToken", null, request.getLocale()));
    }

    // Reset password

//    // Save password
//    @PostMapping("/user/savePassword")
//    public GenericResponse savePassword(final Locale locale, @Valid PasswordDto passwordDto) {
//
//        final String result = securityUserService.validatePasswordResetToken(passwordDto.getToken());
//
//        if(result != null) {
//            return new GenericResponse(messages.getMessage("auth.message." + result, null, locale));
//        }
//
//        Optional<User> user = userService.getUserByPasswordResetToken(passwordDto.getToken());
//        if(user.isPresent()) {
//            userService.changeUserPassword(user.get(), passwordDto.getNewPassword());
//            return new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, locale));
//        } else {
//            return new GenericResponse(messages.getMessage("auth.message.invalid", null, locale));
//        }
//    }

    // Change user password
    @PostMapping("/user/updatePassword")
    public GenericResponse changeUserPassword(final Locale locale, @Valid PasswordDto passwordDto) {
        final User user = userService.findUserByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
        if (!userService.checkIfValidOldPassword(user, passwordDto.getOldPassword())) {
            throw new InvalidOldPasswordException();
        }
        userService.changeUserPassword(user, passwordDto.getNewPassword());
        return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
    }

    // Change user 2 factor authentication
    @PostMapping("/user/update/2fa")
    public GenericResponse modifyUser2FA(@RequestParam("use2FA") final boolean use2FA) throws UnsupportedEncodingException {
        final User user = userService.updateUser2FA(use2FA);
        if (use2FA) {
            return new GenericResponse(userService.generateQRUrl(user));
        }
        return null;
    }

    // ============== NON-API ============

    private SimpleMailMessage constructResendVerificationTokenEmail(final String contextPath, final Locale locale, final VerificationToken newToken, final User user) {
        final String confirmationUrl = contextPath + "/registrationConfirm.html?token=" + newToken.getToken();
        final String message = messages.getMessage("message.resendToken", null, locale);
        return constructEmail("Resend Registration Token", message + " \r\n" + confirmationUrl, user);
    }

    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final User user) {
        final String url = contextPath + "/user/changePassword?token=" + token;
        final String message = messages.getMessage("message.resetPassword", null, locale);
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

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    private String getClientIP(HttpServletRequest request) {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
    
    public static void main(String[] args) {
		UserDto userDto = new UserDto();
		userDto.setFirstName("Anurag");
		userDto.setLastName("Pundir");
		userDto.setEmail("anuragpundir621@gmail.com");
		userDto.setPassword("OURINDIA12");
		userDto.setMatchingPassword("OURINDIA12");
		userDto.setUsing2FA(false);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(userDto));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @RequestMapping("/loadStatesByCountry/{id}")
	public List<Object[]> loadStatesByCountry(@PathVariable("id") String id) {
		
		return categoryRepo.getStatesByCountryId(id);
	}
	
	@RequestMapping("/loadCitiesByState/{id}")
	public List<Object[]> loadCitiesByState(@PathVariable("id") String id) {
		
		return categoryRepo.getCitiesByState(id);
	}
	
	 @RequestMapping(method = RequestMethod.POST, value = "/getSearchedJobs")
		public ResponseEntity<?> getSearchedJobs(@RequestBody SearchJobs searchJob, Map<String, Object> model) throws JsonProcessingException {
		 System.out.println("downloading csv");
		 User user = (User) session.getAttribute("user");
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			model.put("user", user);
			LinkedList<JobData> csvData = new LinkedList();
			JobData headerJobData = new JobData();
			headerJobData.setJobName("Job Name");
			headerJobData.setEmployer("Employer Name");
			headerJobData.setJobType("Job type");
			headerJobData.setCategory("Category Name");
			headerJobData.setNoOfVacancy("No. of vacancy");
			headerJobData.setVacancyForMale("Vacancy for male");
			headerJobData.setVacancyForFemale("Vacancy for female");
			headerJobData.setVacancyForOther("Vacancy for other");
			headerJobData.setDescription("Description");
			headerJobData.setState("State");
			headerJobData.setCity("City");
			headerJobData.setJobCode("Job Code");
			headerJobData.setLocality("Locality");
			headerJobData.setJobDate("Job Date");
			headerJobData.setPostalCode("Postal Code");
			headerJobData.setRate("rate");
			headerJobData.setCreatedDate("Created Date");
			csvData.add(headerJobData);
		 List<JobAccount> jobs = new ArrayList<>();
		 List<Integer> appliedJobIds = new ArrayList<>();
		 List<JobAccount> jobsAccount = jobAccountCustomRepo.findJobsByJobCriterias(searchJob);

			List<JobAccountApplication> jobApplications = jobAccountApplicationRepo.findAllByApplicant(user);
			for (JobAccountApplication accountApplication : jobApplications) {
				appliedJobIds.add(accountApplication.getJob().getId());
			}

			for (JobAccount jobAccount : jobsAccount) {
				if (!appliedJobIds.contains(jobAccount.getId())) {
					if(jobAccount.getStatus()!=null && jobAccount.getStatus().equals("Open"))
					{
						JobData jobData = new JobData();
						jobData.setJobName(jobAccount.getJobName());
						jobData.setEmployer(jobAccount.getEmployer().getEmployerName());
						jobData.setJobType(jobAccount.getJobType().getJobTypeName());
						jobData.setCategory(jobAccount.getCategory().getCategoryName());
						jobData.setNoOfVacancy(String.valueOf(jobAccount.getNoOfVacancy()));
						jobData.setVacancyForMale(String.valueOf(jobAccount.getVacancyForMale()));
						jobData.setVacancyForFemale(String.valueOf(jobAccount.getVacancyForFemale()));
						jobData.setVacancyForOther(String.valueOf(jobAccount.getVacancyForOther()));
						jobData.setDescription(jobAccount.getDescription());
						jobData.setState(jobAccount.getState());
						jobData.setCity(jobAccount.getCity());
						jobData.setJobCode(jobAccount.getJobCode());
						jobData.setLocality(jobAccount.getLocality());
						jobData.setJobDate(dateFormat.format(jobAccount.getJobDate()));
						jobData.setPostalCode(jobAccount.getPostalCode());
						jobData.setRate(String.valueOf(jobAccount.getRate()));
						jobData.setCreatedDate(dateFormat.format(jobAccount.getCreatedDate()));
						
						
						csvData.add(jobData);
					}
					
				}
			}
			
//		    String filename = "searchedJobs.csv";
//		    InputStreamResource file = new InputStreamResource(csvService.jobsToCSV(jobs));
//	
//		    return ResponseEntity.ok()
//		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//		        .contentType(MediaType.parseMediaType("application/csv"))
//		        .body(file);
			
		
			
			return ResponseEntity.ok(csvData);
	 }
}
