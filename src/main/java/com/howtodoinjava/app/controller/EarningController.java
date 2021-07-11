package com.howtodoinjava.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.howtodoinjava.dao.JobEarningRepo;
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
import com.howtodoinjava.model.JobEarning;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;

@Controller
public class EarningController {
	
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
	
	@Autowired
	JobEarningRepo jobEarningRepo;
	
	
	
	@RequestMapping("/earning-genz.html")
	public String category(Map<String, Object> model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<JobEarning> earnings = jobEarningRepo.findAll();
		model.put("earnings", earnings);
		User user = userRepo.findByEmail(authentication.getName());
		model.put("user", user);
		model.put("earnings", earnings);
		return "admin/student_earning";
	}

}
