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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.howtodoinjava.dao.LocationRepository;
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
import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.entity.SearchCandidate;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.TimeSlot;
import com.howtodoinjava.model.JobTimeSlot;
import com.howtodoinjava.model.Location;
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
	LocationRepository locationRepo;

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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("profile", profile);
		model.put("courses", courses);
		model.put("employers", employers);
		model.put("categories", categories);
		model.put("dayPreference", new DayPreference());
		model.put("timeSlots", timeSlotRepo.findAll());
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
		if (categoryId != null) {
			Optional<Category> categoryEntity = categoryRepo.findById(Integer.parseInt(categoryId));
			if (categoryEntity.isPresent()) {
				model.put("category", categoryEntity.get());
			}
		} else {
			category.setCreatedDate(new Date());
			category.setCreatedBy(userRepo.findById(2L).get());
			categoryRepo.save(category);
			model.put("category", categoryRepo.save(category));
			model.put("successMessage", "Category created");
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
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

	@RequestMapping("/jobtype-edit-genz.html")
	public String editJobType(Map<String, Object> model) {
		model.put("jobType", new JobType());
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
			jobType.setCreatedDate(new Date());
			jobType.setCreatedBy(userRepo.findById(2L).get());
			jobTypeRepo.save(jobType);
			model.put("jobType", jobTypeRepo.save(jobType));
			model.put("successMessage", "Job Type created");
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

	@RequestMapping("/genzest-d.html")
	public String showAdminPage(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
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
	public String editCourseType(Map<String, Object> model) {
		model.put("courseType", new CourseType());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		return "admin/course-edit-genz";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/course-edit-genz.html")
	public String editCourseType(@Valid @ModelAttribute("courseType") CourseType courseType, BindingResult result,
			Map<String, Object> model, @RequestParam(required = false) String courseTypeId) {
		if (result.hasErrors()) {
			return "admin/course-edit-genz";
		}
		if (courseTypeId != null) {
			Optional<CourseType> courseTypeEntity = courseRepo.findById(Integer.parseInt(courseTypeId));
			if (courseTypeEntity.isPresent()) {
				model.put("courseType", courseTypeEntity.get());
			}
		} else {
			courseType.setCreatedDate(new Date());
			courseType.setCreatedBy(userRepo.findById(2L).get());
			courseRepo.save(courseType);
			model.put("courseType", courseRepo.save(courseType));
			model.put("successMessage", "Course created");

		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
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
			timeSlot.setCreatedDate(new Date());
			timeSlot.setCreatedBy(userRepo.findById(2L).get());
			model.put("timeSlot", timeSlotRepo.save(timeSlot));
			model.put("successMessage", "Time slot created");
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
		System.out.println("***********88(((((((((((9");
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
	public String editTimeSlot(Map<String, Object> model) {
		System.out.println("***********88");
		model.put("timeSlot", new TimeSlot());
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
		System.out.println("***********88(((((((((((9");
		if (employerId != null) {
			Optional<Employer> employerEntity = employerRepo.findById(Integer.parseInt(employerId));
			if (employerEntity.isPresent()) {
				model.put("employer", employerEntity.get());
			}
		} else {
			employer.setCreatedDate(new Date());
			model.put("employer", employerRepo.save(employer));
			model.put("successMessage", "Employer created!");
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
		model.put("categories", categories);
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

	@RequestMapping("/jobs-genz.html")
	public String showJobs(Map<String, Object> model) {
		System.out.println("***********7777");
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
		System.out.println("***********7777");
		List<TimeSlot> timeSlots = timeSlotRepo.findAll();
		List<Category> categories = categoryRepo.findAll();
		List<Employer> employers = employerRepo.findAll();
		model.put("jobAccount", new JobAccount());
		model.put("timeSlots", timeSlots);
		model.put("categories", categories);
		model.put("employers", employers);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("states", categoryRepo.getStatesByCountryId("100"));
		return "admin/editjobs";
	}

	@RequestMapping("/updatejobs-genz.html")
	public String showUpdateJob(Map<String, Object> model, @RequestParam String jobId) {
		System.out.println("***********7777");
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
		System.out.println("***********88(((((((((((9");
		DayPreference preference = null;

		JobAccount account = jobAccountRepo.findById(jobTimeSlot.getJobId()).get();

		if (!account.getTimeSlots().contains(jobTimeSlot.getTimeSlot())) {
			account.getTimeSlots().add(jobTimeSlot.getTimeSlot());
			jobAccountRepo.save(account);
			model.put("successMessage", "Time slot added to this Job");
		} else {
			model.put("warningMessage", "Time slot is already present to this job");
		}

//		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
//		UserProfile profile = userRepo.findByEmail(authentication.getName()).getUserProfile();
//		Set<DayPreference> preferences = profile.getPreferences();
//		
//		for(DayPreference pref : preferences)
//		{
//			if(pref.getDay().equals(dayPreference.getDay()))
//			{
//				preference = pref;
//				pref.setTimeSlot(dayPreference.getTimeSlot());
//			}
//		}
//		
//		if(preference==null)
//		{
//			profile.getPreferences().add(dayPreference);
//			userProfileRepo.save(profile);
//		}else
//		{
//			profile.setPreferences(preferences);
//			userProfileRepo.save(profile);
//		}
//		
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
		System.out.println("***********88(((((((((((9");
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
				int serialNumber = (int) ((Math.random() * (100 - 1)) + 1);
				String jobCode = account.getEmployer().getClientCode() + "_" + cityObj.get(0)[0] + "_"
						+ account.getCategory().getCategoryCode() + "_" + account.getCreatedDate().getMonth()
						+ account.getCreatedDate().getDate() + account.getCreatedDate().getYear() + "_" + serialNumber;

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
		return to;

	}

}
