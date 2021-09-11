package com.howtodoinjava.app.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.howtodoinjava.dao.JobAccountApplicationRepo;
import com.howtodoinjava.dao.JobEarningRepo;
import com.howtodoinjava.dao.LocationRepository;
import com.howtodoinjava.dao.SelectedProfilesRepo;
import com.howtodoinjava.dao.UserProfileRepository;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.CourseRepo;
import com.howtodoinjava.domain.EmployerRepo;
import com.howtodoinjava.domain.JobAccountCustomRepo;
import com.howtodoinjava.domain.JobAccountRepo;
import com.howtodoinjava.domain.JobTypeRepo;
import com.howtodoinjava.domain.TimeSlotRepo;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.CategoryCount;
import com.howtodoinjava.entity.CourseType;
import com.howtodoinjava.entity.DayPreference;
import com.howtodoinjava.entity.Employer;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.entity.MarkAttendence;
import com.howtodoinjava.entity.SearchCandidate;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.SelectedProfile;
import com.howtodoinjava.entity.TimeSlot;
import com.howtodoinjava.model.JobEarning;
import com.howtodoinjava.model.JobTimeSlot;
import com.howtodoinjava.model.Location;
import com.howtodoinjava.model.OtherUserDetails;
import com.howtodoinjava.model.StudentDocuments;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;

@Controller
public class AdminController {

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
	UserProfileRepository userprofileRepo;

	@Autowired
	JobAccountCustomRepo jobAccountCustomRepo;
	
	@Autowired
	JobAccountApplicationRepo jobAccountApplicationRepo;

	@Autowired
	LocationRepository locationRepo;
	
	@Autowired
	SelectedProfilesRepo selectedProfileRepo;
	
	@Autowired
	JobEarningRepo jobEarningRepo;
	
	
	@Autowired
	HttpSession session;

	@RequestMapping("/category-genz.html")
	public String category(Map<String, Object> model) {
		List<Category> categories = categoryRepo.findAll();
		if (categories.size() > 0) {
			model.put("categories", categories);
		}
		return "admin/category-genz";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedstud-genz.html")
	public String selectedStud(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("category", new Category());
		List<JobAccountApplication> applications = jobAccountApplicationRepo.findAllByApplicantAndStatus((User)model.get("user"),"SELECTED");
		List<JobAccountApplication> presentApplications = jobAccountApplicationRepo.findAllByApplicantAndStatus((User)model.get("user"),"MARKED");
		
		model.put("applications", applications);
		model.put("presentApplications", presentApplications);
		return "admin/selectedstud-genz";
	}

	@RequestMapping("/edit_stud.html")
	public String edit(Map<String, Object> model, @RequestParam String profileId) {
		model.put("message", "HowToDoInJava Reader !!");
		UserProfile profile = null;
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userRepo.findByEmail(authentication.getName());
			model.put("user", user);
			profile = userprofileRepo.findById(Integer.parseInt(profileId)).get();
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			System.out.println(profile + "  *****");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("profile", profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findAll());
		OtherUserDetails userDetails = profile.getOtherDetails();
		if(userDetails==null)
		{
			model.put("otherDetails",new OtherUserDetails());
		}else
		{
			model.put("otherDetails", userDetails);
		}
		if(profile.getParentsName()==null)
		{
			model.put("editable", true);
		}else
		{
			model.put("editable", false);
		}
		StudentDocuments studentDocuments = profile.getStudentDocuments()==null?new StudentDocuments():profile.getStudentDocuments();
		model.put("studentDocs", studentDocuments);

		return "admin/edit_genz";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/stud-genz.html")
	public String student_genz(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<UserProfile> userProfiles = (List<UserProfile>) userprofileRepo.findAll();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("profiles", userProfiles);
		return "admin/stud-genz";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/category-edit-genz.html")
	public String editCategoryGet(Map<String, Object> model) {
//		if (categoryId != null) {
//			Optional<Category> categoryEntity = categoryRepo.findById(Integer.parseInt(categoryId));
//			if (categoryEntity.isPresent()) {
//				model.put("category", categoryEntity.get());
//			}
//		} else {
//			category.setCreatedDate(new Date());
//			category.setCreatedBy(userRepo.findById(2L).get());
//			categoryRepo.save(category);
//			model.put("category", categoryRepo.save(category));
//
//		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("category", new Category());
		return "admin/category-edit-genz";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editCategory.html")
	public String editCategoryQuery(Map<String, Object> model, @RequestParam(required = false) String categoryId) {
		if (categoryId != null) {
			Optional<Category> categoryEntity = categoryRepo.findById(Integer.parseInt(categoryId));
			if (categoryEntity.isPresent()) {
				model.put("category", categoryEntity.get());
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/category-edit-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/category-edit-genz.html")
	public String editCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String categoryId) {
		if (result.hasErrors()) {
			return "admin/category-edit-genz";
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		if (categoryId != null) {
			Optional<Category> categoryEntity = categoryRepo.findById(Integer.parseInt(categoryId));
			if (categoryEntity.isPresent()) {
				model.put("category", categoryEntity.get());
			}
		} else {
			if(category.getId()==0)
			{
				if(categoryRepo.findByCategoryName(category.getCategoryName())!=null)
				{
					model.put("errorMessage", "Category already Exists");
					model.put("category", category);
					return "admin/category-edit-genz";
				}
				category.setCreatedDate(new Date());
				category.setCreatedBy(user);
				categoryRepo.save(category);
				model.put("category", categoryRepo.save(category));
				model.put("successMessage", "Category created");
			}
			else
			{
				category.setCreatedDate(new Date());
				category.setCreatedBy(user);
				categoryRepo.save(category);
				model.put("category", categoryRepo.save(category));
				model.put("successMessage", "Category Updated");
			}
			
		}
		
		return "admin/category-edit-genz";
	}

	@RequestMapping("/jobtype-genz.html")
	public String jobType(Map<String, Object> model) {

		List<JobType> jobTypes = jobTypeRepo.findAll();
		if (jobTypes.size() > 0) {
			model.put("jobTypes", jobTypes);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/jobtype-genz";
	}

	
	@RequestMapping("/approveStud.html")
	public void approveStud(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		String applicationId = request.getParameter("applicationId");
		
		if (!StringUtils.isEmpty(applicationId)) {
			Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo
					.findById(Long.parseLong(applicationId));
			JobAccountApplication application = jobApplication.get();
			application.setStatus("APPROVED");
			jobAccountApplicationRepo.save(application);
			
			JobEarning earning = new JobEarning();
			earning.setApplicantUser(user);
			earning.setJobAccount(application.getJob());
			earning.setPresentDate(new Date());
			earning.setStatus("CREATED");
			earning.setTotalEarning(500);
			earning.setTotalHours(8);
			jobEarningRepo.save(earning);
			session.setAttribute("successMessage", "Student Application Approved!!");
			response.sendRedirect("/selectedstud-genz.html");
		}else
		{
		session.setAttribute("errorMessage", "Didn't find any application with this id, please choose another one.");
		response.sendRedirect("/selectedstud-genz.html");
		}
	}
	
	
	
	@RequestMapping("/rejectStud.html")
	public void rejectStud(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		String applicationId = request.getParameter("applicationId");
		
		if (!StringUtils.isEmpty(applicationId)) {
			Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo
					.findById(Long.parseLong(applicationId));
			JobAccountApplication application = jobApplication.get();
			application.setStatus("REJECTED");
			jobAccountApplicationRepo.save(application);
			
			
			session.setAttribute("successMessage", "Student Application Rejected!!");
			response.sendRedirect("/selectedstud-genz.html");
		}else
		{
		session.setAttribute("errorMessage", "Didn't find any application with this id, please choose another one.");
		response.sendRedirect("/selectedstud-genz.html");
		}
	}
	
	@RequestMapping("/jobtype-edit-genz.html")
	public String editJobType(Map<String, Object> model, @RequestParam(required = false) String jobTypeId) {
		
		model.put("jobType", new JobType());
		if(jobTypeId!=null)
		{
			Optional<JobType> jobType = jobTypeRepo.findById(Integer.parseInt(jobTypeId));
			if(jobType.isPresent())
			{
				model.put("jobType", jobType.get());
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/jobtype-edit-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/jobtype-edit-genz.html")
	public String editJobType(@Valid @ModelAttribute("jobType") JobType jobType, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String jobTypeId) {

		if (result.hasErrors()) {
			return "admin/jobtype-edit-genz";
		}
		if (jobTypeId != null) {
			Optional<JobType> jobTypeEntity = jobTypeRepo.findById(Integer.parseInt(jobTypeId));
			if (jobTypeEntity.isPresent()) {
				model.put("jobType", jobTypeEntity.get());
			}
		} else {
			if(jobType.getId()==0)
			{
				if(jobTypeRepo.findByJobTypeName(jobType.getJobTypeName())!=null)
				{
					model.put("errorMessage", "JobType already Exists");
					model.put("jobType", jobType);
					return "admin/jobtype-edit-genz";
				}
				jobType.setCreatedDate(new Date());
				jobType.setCreatedBy(userRepo.findById(2L).get());
				jobTypeRepo.save(jobType);
				model.put("jobType", jobTypeRepo.save(jobType));
				model.put("successMessage", "Job Type created");
			}else
			{
				jobType.setCreatedDate(new Date());
				jobType.setCreatedBy(userRepo.findById(2L).get());
				jobTypeRepo.save(jobType);
				model.put("jobType", jobTypeRepo.save(jobType));
				model.put("successMessage", "Job Type Updated");
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/jobtype-edit-genz";
	}

	@RequestMapping("/course-genz.html")
	public String course(Map<String, Object> model) {

		List<CourseType> courseTypes = courseRepo.findAll();
		if (courseTypes.size() > 0) {
			model.put("courseTypes", courseTypes);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/course-genz";
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/genzest-d.html")
	public String showAdminPage(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		System.out.println(user.getRoles());
		model.put("courseCount", courseRepo.count());
		model.put("employersCount", employerRepo.count());
		model.put("categoriesCount", categoryRepo.count());
		model.put("dayPreference", new DayPreference());
		model.put("timeSlotsCount", timeSlotRepo.count());
		model.put("studentCount", userprofileRepo.count());
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

		return "admin/genzest-d";
	}

	@RequestMapping("/course-edit-genz.html")
	public String editCourseType(Map<String, Object> model, @RequestParam(required = false) String courseId) {
		
		model.put("courseType", new CourseType());
		if(courseId!=null)
		{
			Optional<CourseType> courseType = courseRepo.findById(Integer.parseInt(courseId));
			if(courseType.isPresent())
			{
				model.put("courseType", courseType.get());
			}
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/course-edit-genz";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/course-edit-genz.html")
	public String editCourseType(@Valid @ModelAttribute("courseType") CourseType courseType, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String courseTypeId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		if (result.hasErrors()) {
			return "admin/course-edit-genz";
		}
		if (courseTypeId != null) {
			Optional<CourseType> courseTypeEntity = courseRepo.findById(Integer.parseInt(courseTypeId));
			if (courseTypeEntity.isPresent()) {
				model.put("courseType", courseTypeEntity.get());
			}
		} else {
			
			if(courseType.getId()==0)
			{
				if(courseRepo.findByCourseTypeName(courseType.getCourseTypeName())!=null)
				{
					model.put("errorMessage", "Course already Exists");
					model.put("courseType", courseType);
					return "admin/course-edit-genz";
				}
				courseType.setCreatedDate(new Date());
				courseType.setCreatedBy(user);
				courseRepo.save(courseType);
				model.put("courseType", courseRepo.save(courseType));
				model.put("successMessage", "Course created");
			}else
			{
				courseType.setCreatedDate(new Date());
				courseType.setCreatedBy(user);
				courseRepo.save(courseType);
				model.put("courseType", courseRepo.save(courseType));
				model.put("successMessage", "Course Updated");
			}

		}
		
		model.put("user", user);
		return "admin/course-edit-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/timeslot-edit-genz.html")
	public String saveTimeSlot(@Valid @ModelAttribute("timeSlot") TimeSlot timeSlot, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String timeSlotId) {
		if (result.hasErrors()) {
			return "admin/timeslot-edit-genz";
		}
		if (timeSlotId != null) {
			Optional<TimeSlot> timeSLotEntity = timeSlotRepo.findById(Integer.parseInt(timeSlotId));
			if (timeSLotEntity.isPresent()) {
				model.put("timeSlot", timeSLotEntity.get());
			}
		} else {
			
			if(timeSlot.getId()==0)
			{
				if(timeSlotRepo.findByTimeSlotName(timeSlot.getTimeSlotName())!=null)
				{
					model.put("errorMessage", "Timeslot already Exists");
					model.put("timeSlot", timeSlot);
					return "admin/timeslot-edit-genz";
				}
				timeSlot.setCreatedDate(new Date());
				timeSlot.setCreatedBy(userRepo.findById(2L).get());
				model.put("timeSlot", timeSlotRepo.save(timeSlot));
				model.put("successMessage", "Time slot created");
			}else
			{
			timeSlot.setCreatedDate(new Date());
			timeSlot.setCreatedBy(userRepo.findById(2L).get());
			model.put("timeSlot", timeSlotRepo.save(timeSlot));
			model.put("successMessage", "Time slot Updated");
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/timeslot-edit-genz";
	}

	@RequestMapping("/timeslot-genz.html")
	public String timeSlot(Map<String, Object> model) {

//		jobAccountRepo.deleteAll();
		List<TimeSlot> timeSlots = timeSlotRepo.findAll();
		if (timeSlots.size() > 0) {
			model.put("timeSlots", timeSlots);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/timeslot-genz";
	}

	@RequestMapping("/searchjobs-genz.html")
	public String searchJobs(Map<String, Object> model) {
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<JobAccount> jobs = new ArrayList<JobAccount>();
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			timeSlots = timeSlotRepo.findAll();

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
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/searchjobs-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/searchjobs-genz.html")
	public String editJob(@ModelAttribute("searchJob") SearchJobs searchJob, Map<String, Object> model)
			throws Exception {
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<JobAccount> jobs = null;
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			jobTypes = jobTypeRepo.findAll();
			timeSlots = timeSlotRepo.findAll();
			jobs = jobAccountRepo.findAll();

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
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("successMessage", "Refined Results has been posted!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/searchjobs-genz";
	}

	@RequestMapping("/timeslot-edit-genz.html")
	public String editTimeSlot(Map<String, Object> model, @RequestParam(required = false) String timeSlotId) {
		
		
		model.put("timeSlot", new TimeSlot());
		
		if(timeSlotId!=null)
		{
			Optional<TimeSlot> timeSlot = timeSlotRepo.findById(Integer.parseInt(timeSlotId));
			if(timeSlot.isPresent())
			{
				model.put("timeSlot", timeSlot.get());
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/timeslot-edit-genz";
	}

//	@RequestMapping(method = RequestMethod.POST,value = "/timeslot-edit-genz.html")
//	public String editTimeSlot(@ModelAttribute("timeSlot") TimeSlot timeSlot, Map<String, Object> model,
//			@RequestParam(required = false) String timeSlotId) {
//		System.out.println("***********88(((((((((((9");
//		if (timeSlotId != null) {
//			Optional<TimeSlot> timeSlotEntity = timeSlotRepo.findById(Integer.parseInt(timeSlotId));
//			if (timeSlotEntity.isPresent()) {
//				model.put("timeSlot", timeSlotEntity.get());
//			}
//		} else {
//			timeSlot.setCreatedDate(new Date());
//			timeSlot.setCreatedBy(userRepo.findById(2L).get());
//			timeSlotRepo.save(timeSlot);
//			model.put("timeSlot", timeSlotRepo.save(timeSlot));
//
//		}
//		return "admin/timeslot-genz";
//	}

	@RequestMapping("/employer-genz.html")
	public String employer(Map<String, Object> model) {
		List<Employer> employers = employerRepo.findAll();
//		if (employers.size() > 0) {
		model.put("employers", employers);
//		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/employer-genz";
	}

	@RequestMapping("/emp-edit-genz.html")
	public String employerEdit(Map<String, Object> model) {
		System.out.println("***********7777");
		model.put("employer", new Employer());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		return "admin/emp-edit-genz";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editEmployer.html")
	public String editEmployer(Map<String, Object> model, @RequestParam(required = false) String employerId) {

		System.out.println("***********88(((((((((((9");
		if (employerId != null) {
			Optional<Employer> employerEntity = employerRepo.findById(Integer.parseInt(employerId));
			if (employerEntity.isPresent()) {
				model.put("employer", employerEntity.get());
			}
		}
		model.put("showLocations", true);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		return "admin/emp-edit-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/emp-edit-genz.html")
	public String editTimeSlot(@Valid @ModelAttribute("employer") Employer employer, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String employerId) {
		if (result.hasErrors()) {
			return "admin/emp-edit-genz";
		}
		if (employerId != null) {
			Optional<Employer> employerEntity = employerRepo.findById(Integer.parseInt(employerId));
			if (employerEntity.isPresent()) {
				model.put("employer", employerEntity.get());
			}
		} else {
			if(employer.getId()==0)
			{
				if(employerRepo.findByEmployerName(employer.getEmployerName())!=null)
				{
					model.put("errorMessage", "Employer Name already Exists");
					model.put("employer", employer);
					return "admin/emp-edit-genz";
				}
				
				if(employerRepo.findByClientCode(employer.getClientCode())!=null)
				{
					model.put("errorMessage", "Employer code already exists");
					model.put("employer", employer);
					return "admin/emp-edit-genz";
				}
				employer.setCreatedDate(new Date());
				model.put("employer", employerRepo.save(employer));
				model.put("successMessage", "Employer created!");
			}else
			{
			
			employer.setCreatedDate(new Date());
			model.put("employer", employerRepo.save(employer));
			model.put("successMessage", "Employer created!");
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("user", user);
		return "admin/emp-edit-genz";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateLocations.html")
	public String updateEmployerLocations(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DayPreference preference = null;

		String location = request.getParameter("cityLocation");

		String employerId = request.getParameter("empId");

		if (employerId != null) {
			Optional<Employer> employerEntity = employerRepo.findById(Integer.parseInt(employerId));
			Employer emp = employerEntity.get();
			if (employerEntity.isPresent()) {

				Location loc = locationRepo.findByLocation(location);
				if (loc != null) {
					if (!emp.getLocations().contains(loc)) {
						emp.getLocations().add(loc);
						employerRepo.save(emp);
						model.put("employer", emp);
						model.put("successMessage", "Location added!");
					} else {
						model.put("warningMessage", "This location is already present for this Employer");
					}
				} else {
					Location newLoc = new Location();
					newLoc.setLocation(location);
					emp.getLocations().add(newLoc);
					employerRepo.save(emp);
					
					model.put("successMessage", "Location added!");
				}
				model.put("employer", emp);
			}
			else
			{
				model.put("warningMessage", "No Employer present for this id");
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("showLocations", true);
		return "admin/emp-edit-genz";
	}

	@RequestMapping("/searchcandi-genz.html")
	public String showSearchCandiate(Map<String, Object> model) {
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<UserProfile> profiles = new ArrayList<UserProfile>();
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			jobTypes = jobTypeRepo.findAll();
			timeSlots = timeSlotRepo.findAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("courses", courses);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("jobTypes", jobTypes);
		model.put("timeSlots", timeSlots);
		model.put("profiles", profiles);
		model.put("searchCandidate", new SearchCandidate());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/search-candidate";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchJobInfo.html")
	public String showCandidateInfo(HttpServletRequest request,HttpServletResponse response,
			Map<String, Object> model) throws Exception {
		System.out.println("***********88(((((((((((9");
		List<UserProfile> profiles = new ArrayList<>();
		String jobId = request.getParameter("jobId");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		List<Integer> selectedProfilesIds = new ArrayList<>();
		JobAccount job = jobAccountRepo.findByJobCode(jobId);
		
		if(job!=null)
		{
			JobAccount jobAccount = job;
			SearchCandidate candidate = new SearchCandidate();
			candidate.setJobCategory(String.valueOf(jobAccount.getCategory().getId()));
//			candidate.setTimeSlot(jobAccount.getTimeSlot().getTimeSlotName());
//			candidate.setCity(jobAccount.getCity());
//			candidate.setJobType(String.valueOf(jobAccount.getJobType().getId()));
//			candidate.setState(jobAccount.getState());
//			candidate.setCity(jobAccount.getCity());
		
			
			List<OtherUserDetails> userDetails = (List<OtherUserDetails>) jobAccountCustomRepo.findProfileBySearchJob(candidate);
			
			List<SelectedProfile> applications = selectedProfileRepo.findAllBySelectedBy((User)model.get("user"));
			for(SelectedProfile selectedProfile : applications)
			{
				selectedProfilesIds.add(selectedProfile.getUserProfile().getId());
			}
			
			for(OtherUserDetails profile : userDetails)
			{
				
				if(!selectedProfilesIds.contains(profile.getUserProfile().getId()))
				{
				profiles.add(profile.getUserProfile());
				}
			}
			
			SearchCandidate searchCandidate = new SearchCandidate();
			searchCandidate.setJobCategory(jobAccount.getCategory().getCategoryName());
			searchCandidate.setEmployerName(jobAccount.getEmployer().getEmployerName());
			searchCandidate.setJobType(jobAccount.getJobType().getJobTypeName());
			searchCandidate.setState(jobAccount.getState());
			searchCandidate.setCity(jobAccount.getCity());
			model.put("searchCandidate", searchCandidate);
			model.put("successMessage", "Refined results has been posted!");
		}
		else
		{
			model.put("errorMessage", "Not able to find job by this Job Id");
			model.put("searchCandidate", new SearchCandidate());
		}
		
//		List<CourseType> courses = null;
//		List<Employer> employers = null;
//		List<Category> categories = null;
//		List<JobType> jobTypes = null;
//		List<TimeSlot> timeSlots = null;
//		List<UserProfile> profiles = null;
//		try {
//			courses = courseRepo.findAll();
//			employers = employerRepo.findAll();
//			categories = categoryRepo.findAll();
//			jobTypes = jobTypeRepo.findAll();
//			timeSlots = timeSlotRepo.findAll();
//			profiles = (List<UserProfile>) jobAccountCustomRepo.findProfileByProfileCriterias(searchCandidate);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		model.put("courses", courses);
//		model.put("employers", employers);
//		model.put("categories", categories);
//		model.put("jobTypes", jobTypes);
//		model.put("timeSlots", timeSlots);
//		model.put("profiles", profiles);
//		model.put("searchJob", new SearchJobs());
//		model.put("states", categoryRepo.getStatesByCountryId("100"));
//		model.put("successMessage", "Refined Results has been posted!");
		model.put("profiles", profiles);
		
		return "admin/search-candidate";
	}



	@RequestMapping(method = RequestMethod.POST, value = "/searchCandidates.html")
	public String searchCandidate(@ModelAttribute("searchCandidate") SearchCandidate searchCandidate,
			Map<String, Object> model) throws Exception {
		System.out.println("***********88(((((((((((9");
		List<CourseType> courses = null;
		List<Employer> employers = null;
		List<Category> categories = null;
		List<JobType> jobTypes = null;
		List<TimeSlot> timeSlots = null;
		List<UserProfile> profiles = null;
		try {
			courses = courseRepo.findAll();
			employers = employerRepo.findAll();
			categories = categoryRepo.findAll();
			jobTypes = jobTypeRepo.findAll();
			timeSlots = timeSlotRepo.findAll();
			profiles = (List<UserProfile>) jobAccountCustomRepo.findProfileByProfileCriterias(searchCandidate);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("courses", courses);
		model.put("employers", employers);
		model.put("jobTypes", jobTypes);
		model.put("timeSlots", timeSlots);
		model.put("profiles", profiles);
		model.put("searchJob", new SearchJobs());
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		model.put("successMessage", "Refined Results has been posted!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/search-candidate";
	}

	@RequestMapping("/selectProfiles")
	public void applyJob(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
			@RequestParam String profilesId,HttpSession session) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (profilesId.contains(",")) {
			String[] profilesIds = profilesId.split(",");
			if (profilesIds.length > 0) {
				for (String profile : profilesIds) {
//					Optional<UserProfile> userProfileOptional = userprofileRepo.findById(Integer.parseInt(profile));
//					if (userProfileOptional.isPresent()) {
//						SelectedProfile selectedProfile = new SelectedProfile();
//						selectedProfile.setUserProfile(userProfileOptional.get());
//						selectedProfile.setSelectedDate(new Date());
//						User user = userRepo.findByEmail(auth.getName());
//						model.put("user", user);
//						selectedProfile.setSelectedBy(user);
//						selectedProfileRepo.save(selectedProfile);
//					}
					
					Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo.findById(Long.parseLong(profile));
					if (jobApplication.isPresent()) {
						JobAccountApplication application = jobApplication.get();
						application.setStatus("SELECTED");
						jobAccountApplicationRepo.save(application);
					}
				}
			}
		} else {
//			Optional<UserProfile> userProfileOptional = userprofileRepo.findById(Integer.parseInt(profilesId));
//			if (userProfileOptional.isPresent()) {
//				SelectedProfile selectedProfile = new SelectedProfile();
//				selectedProfile.setUserProfile(userProfileOptional.get());
//				selectedProfile.setSelectedDate(new Date());
//				User user = userRepo.findByEmail(auth.getName());
//				model.put("user", user);
//				selectedProfile.setSelectedBy(user);
//				selectedProfileRepo.save(selectedProfile);
//			}
			
			Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo.findById(Long.parseLong(profilesId));
			if (jobApplication.isPresent()) {
				JobAccountApplication application = jobApplication.get();
				application.setStatus("SELECTED");
				jobAccountApplicationRepo.save(application);
			}

		}
		session.setAttribute("successMessage", "Profiles Selected"); 
//		List<SelectedProfile> applications = selectedProfileRepo.findAllBySelectedBy((User)model.get("user"));
//		model.put("applications", applications);
		response.sendRedirect("/selectedstud-genz.html");
		
	}
	
	@RequestMapping(value = "/editAttendence.html", method = RequestMethod.GET)
	public String markAttendence(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
			@RequestParam String applicationId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(auth.getName());
		model.put("user", user);
		model.put("applicationId", applicationId);
		Optional<JobAccountApplication> jobApplication = jobAccountApplicationRepo
				.findById(Long.parseLong(applicationId));
		JobAccountApplication application = jobApplication.get();
		
		MarkAttendence markAttendence = new MarkAttendence();
		markAttendence.setCheckinTime(application.getCheckinTime());
		markAttendence.setCheckoutTime(application.getCheckoutTime());
		model.put("markAttendence", markAttendence);
		return "admin/editattendence";
	}
	
	
	@RequestMapping(value = "/editAttendencePost.html", method = RequestMethod.POST)
	public String markAttendence(@ModelAttribute("markAttendence") MarkAttendence markAttendence, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
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
			session.setAttribute("successMessage", "Attendence Edited!");
			response.sendRedirect("/selectedstud-genz.html");
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) session.getAttribute("user");
		model.put("user", user);
		model.put("errorMessage", "Input details invalid");
		return "admin/editattendence";
	}

	
	@RequestMapping("/jobs-genz.html")
	public String showJobs(Map<String, Object> model) {
		List<JobAccount> jobs = new ArrayList<JobAccount>();
		jobs = jobAccountRepo.findAll();
		model.put("jobs", jobs);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/jobs-genz";
	}

	@RequestMapping("/editjobs-genz.html")
	public String showEditJob(Map<String, Object> model) {
		List<TimeSlot> timeSlots = timeSlotRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		List<Employer> employers = employerRepo.findAll();
		List<JobType> jobTypes = jobTypeRepo.findAll();
		model.put("jobAccount", new JobAccount());
		model.put("timeSlots", timeSlots);
		model.put("categories", categories);
		model.put("employers", employers);
		model.put("jobTypes", jobTypes);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		return "admin/editjobs";
	}

	@RequestMapping("/updatejobs-genz.html")
	public String showUpdateJob(Map<String, Object> model, @RequestParam String jobId) {
		List<TimeSlot> timeSlots = timeSlotRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
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
		return "admin/updatejobs";
	}
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/updateJobTimeSlots.html")
	public void searchJobs(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("jobTimeSlot") JobTimeSlot jobTimeSlot) throws Exception {
		DayPreference preference = null;

		JobAccount account = jobAccountRepo.findById(jobTimeSlot.getJobId()).get();

		if (!account.getTimeSlots().contains(jobTimeSlot.getTimeSlot())) {
			account.getTimeSlots().add(jobTimeSlot.getTimeSlot());
			jobAccountRepo.save(account);
			model.put("successMessage", "Time slot added to this Job");
		} else {
			model.put("warningMessage", "Time slot is already present to this job");
		}	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		response.sendRedirect("/jobs-genz.html");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editjobs-genz.html")
	public String saveJob(@Valid @ModelAttribute("jobAccount") JobAccount jobAccount, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String jobAccountId) {
		if (result.hasErrors()) {
			return "admin/editjobs";
		}
		if (jobAccountId != null) {
			Optional<JobAccount> jobAccountEntity = jobAccountRepo.findById(Integer.parseInt(jobAccountId));
			if (jobAccountEntity.isPresent()) {
				model.put("jobAccount", jobAccountEntity.get());
			}
		} else {
			long noOfDaysBetween = ChronoUnit.DAYS.between(
					jobAccount.getEffectiveFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
					jobAccount.getEffectiveTill().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

			System.out.println(noOfDaysBetween);

			List<LocalDate> listOfDates1 = Stream
					.iterate(jobAccount.getEffectiveFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
							date -> date.plusDays(1))
					.limit(noOfDaysBetween).collect(Collectors.toList());

			System.out.println(listOfDates1);
			listOfDates1.forEach((date) -> {
				JobAccount account = new JobAccount();
				account = setFields(jobAccount, account);
				account.setCreatedDate(new Date());
				account.setCreatedBy(userRepo.findById(2L).get());
				account.setStatus("Open");
				account.setJobDate(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

//				Optional<TimeSlot> slot1 = timeSlotRepo.findById(6);
//				account.getTimeSlots().add(slot1.get());
//				
				List<Object[]> cityObj = categoryRepo.getCityByCityName(account.getCity());
				String cityName = (String) cityObj.get(0)[1];
				int serialNumber = (int) ((Math.random() * (1000 - 1)) + 1);
				String jobCode = account.getEmployer().getClientCode() + "_" + cityName.substring(0,3).toUpperCase() + "_"
						+ account.getCategory().getCategoryCode() + "_" + account.getJobDate().getMonth()
						+ account.getJobDate().getDate() + account.getJobDate().getYear() + "_" + serialNumber;

				account.setJobCode(jobCode);
				System.out.println(account);
				jobAccountRepo.save(account);
			});
//			jobAccount.setCreatedDate(new Date());
//			jobAccount.setCreatedBy(userRepo.findById(2L).get());
			
		}
		model.put("successMessage", "Job Created!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		return "admin/editjobs";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatejobs-genz.html")
	public String updateJob(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("jobAccount") JobAccount jobAccount, Map<String, Object> model,
			@RequestParam(required = false) String jobAccountId) {
		model.put("jobAccount", jobAccountRepo.save(jobAccount));
		try {
			response.sendRedirect("/jobs-genz.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "admin/updatejobs";
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/jobs-genz";

	}

	public static JobAccount setFields(JobAccount from, JobAccount to) {

		to.setAction(from.getAction());
		to.setCategory(from.getCategory());
		to.setCity(from.getCity());
		to.setCreatedBy(from.getCreatedBy());
		to.setCreatedDate(to.getCreatedDate());
		to.setDay(from.getDay());
		to.setDescription(from.getDescription());
		to.setEmployer(from.getEmployer());
		to.setJobName(from.getJobName());
		to.setLocality(from.getLocality());
		to.setNoOfVacancy(from.getNoOfVacancy());
		to.setPostalCode(from.getPostalCode());
		to.setRate(from.getRate());
		to.setState(from.getState());
		to.setStatus(from.getStatus());
		to.setTimeSlot(from.getTimeSlot());
		to.setVacancyForFemale(from.getVacancyForFemale());
		to.setVacancyForMale(from.getVacancyForMale());
		to.setVacancyForOther(from.getVacancyForOther());
		to.setJobType(from.getJobType());
		return to;

	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/appliedJobs.html")
	public String appliedJobs(Map<String, Object> model, @RequestParam(required = false) String jobId) {

		List<JobAccountApplication> profiles = null;
		List<UserProfile> userProfiles = new ArrayList<>();
		if (jobId != null) {
			
			try {
				
				Optional<JobAccount> job = jobAccountRepo.findById(Integer.parseInt(jobId));
				profiles = jobAccountApplicationRepo.findByJob(job.get());
//				for(JobAccountApplication accountApplication : profiles)
//				{
//					userProfiles.add(accountApplication.getApplicant().getUserProfile());
//				}
				model.put("profiles", profiles);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/applied-jobs";
	}

}
