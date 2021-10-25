package com.howtodoinjava.app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.howtodoinjava.dao.UserProfileRepository;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.CourseRepo;
import com.howtodoinjava.domain.EmployerRepo;
import com.howtodoinjava.domain.JobAccountRepo;
import com.howtodoinjava.domain.JobTypeRepo;
import com.howtodoinjava.domain.TimeSlotRepo;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.Employer;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.TimeSlot;

@Controller
public class RecruiterController {

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
		
		@RequestMapping("/recruiter-d.html")
		public String showAdminPage(Map<String, Object> model) {
			
			return "recruiter/recruiter-d";
		}
		
		@RequestMapping("/jobs.html")
		public String showJobs(Map<String, Object> model) {
			System.out.println("***********7777");
			List<JobAccount> jobs = new ArrayList<JobAccount>();
			jobs = jobAccountRepo.findAll();
			model.put("jobs",jobs);
			
			return "recruiter/jobs-genz";
		}
		
		@RequestMapping("/editjobs-recruiter.html")
		public String showEditJob(Map<String, Object> model) {
			System.out.println("***********7777");
			List<TimeSlot> timeSlots = timeSlotRepo.findAll();
			List<Category> categories = categoryRepo.findAll();
			List<Employer> employers = employerRepo.findAll();
			model.put("jobAccount",new JobAccount());
			model.put("timeSlots",timeSlots);
			model.put("categories",categories);
			model.put("employers",employers);
			
			return "recruiter/editjobs";
		}
		

		@RequestMapping("/updatejobs-recruiter.html")
		public String showUpdateJob(Map<String, Object> model,@RequestParam String jobId) {
			System.out.println("***********7777");
			List<TimeSlot> timeSlots = timeSlotRepo.findAll();
			List<Category> categories = categoryRepo.findAll();
			List<Employer> employers = employerRepo.findAll();
			if (jobId != null) {
				Optional<JobAccount> jobAccountEntity = jobAccountRepo.findById(Integer.parseInt(jobId));
				if (jobAccountEntity.isPresent()) {
					model.put("jobAccount", jobAccountEntity.get());
				}
			}else
			{
				model.put("jobAccount",new JobAccount());
			}
			model.put("timeSlots",timeSlots);
			model.put("categories",categories);
			model.put("employers",employers);
			
			return "recruiter/updatejobs";
		}
		
		
		@RequestMapping(method = RequestMethod.POST,value = "/editjobs-recruiter.html")
		public String saveJob(@ModelAttribute("jobAccount") JobAccount jobAccount, Map<String, Object> model,
				@RequestParam(required = false) String jobAccountId) {
			System.out.println("***********88(((((((((((9");
			if (jobAccountId != null) {
				Optional<JobAccount> jobAccountEntity = jobAccountRepo.findById(Integer.parseInt(jobAccountId));
				if (jobAccountEntity.isPresent()) {
					model.put("jobAccount", jobAccountEntity.get());
				}
			} else {
				long noOfDaysBetween = ChronoUnit.DAYS.between(jobAccount.getEffectiveFrom().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime(), jobAccount.getEffectiveTill().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime());
				
				System.out.println(noOfDaysBetween);
				
				List<LocalDate> listOfDates1 = Stream.iterate(jobAccount.getEffectiveFrom().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate(), date -> date.plusDays(1))
	                    .limit(noOfDaysBetween)
	                    .collect(Collectors.toList());
				
				System.out.println(listOfDates1);
				listOfDates1.forEach((date)->{
					JobAccount account = new JobAccount();
					account = setFields(jobAccount, account);
					account.setCreatedDate(new Date());
					account.setCreatedBy(userRepo.findById(2L).get());
					account.setStatus("Open");
					account.setJobDate(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
					int serialNumber = (int) ((Math.random() * (100 - 1)) + 1);
					String jobCode = account.getEmployer().getEmployerName()+"_"+account.getCity()+"_"+account.getCategory().getCategoryName()+"_"+account.getCreatedDate().getMonth()+account.getCreatedDate().getDate()+account.getCreatedDate().getYear()+"_"+serialNumber;
					account.setJobCode(jobCode);
				System.out.println(account);
				jobAccountRepo.save(account);
				});
//				jobAccount.setCreatedDate(new Date());
//				jobAccount.setCreatedBy(userRepo.findById(2L).get());
//				model.put("jobAccount", jobAccountRepo.save(jobAccount));
			}
			return "recruiter/editjobs";
		}
		
		@RequestMapping(method = RequestMethod.POST,value = "/updatejobs-recruiter.html")
		public String updateJob(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("jobAccount") JobAccount jobAccount, Map<String, Object> model,
				@RequestParam(required = false) String jobAccountId) {
			model.put("jobAccount", jobAccountRepo.save(jobAccount));
			try {
				response.sendRedirect("/jobs-genz.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return "admin/updatejobs";
			}
			return "recruiter/jobs-genz";
			
		}
		
		@RequestMapping("/emloyer.html")
		public String employer(Map<String, Object> model) {
			List<Employer> employers = employerRepo.findAll();
//			if (employers.size() > 0) {
				model.put("employers", employers);
//			}
			return "recruiter/employer";
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
//			to.setTimeSlot(from.getTimeSlot());
			to.setVacancyForFemale(from.getVacancyForFemale());
			to.setVacancyForMale(from.getVacancyForMale());
			to.setVacancyForOther(from.getVacancyForOther());
			return to;
			
	    }

		
}
