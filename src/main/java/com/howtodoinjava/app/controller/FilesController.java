package com.howtodoinjava.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.dao.JobAccountApplicationRepo;
import com.howtodoinjava.dao.JobCategoryRepo;
import com.howtodoinjava.dao.SelectedProfilesRepo;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.JobAccountCustomRepo;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.entity.SearchCandidate;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.SelectedProfile;
import com.howtodoinjava.model.OtherUserDetails;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;
import com.howtodoinjava.service.CSVService;

@Controller
public class FilesController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CSVService csvService;
	
	@Autowired
	JobAccountCustomRepo jobAccountCustomRepo;
	
	@Autowired
	CategoryRepo jobCategoryRepo;
	
	@Autowired
	SelectedProfilesRepo selectedProfileRepo;
	
	@Autowired
	JobAccountApplicationRepo jobAccountApplicationRepo;
	
	
	@Autowired
	UserRepository userRepo;
	
	
	 @GetMapping("/downloadJobs")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "jobs.csv";
	    InputStreamResource file = new InputStreamResource(csvService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	 
	 
	 
	 @GetMapping("/downloadProfileData")
	  public ResponseEntity<Resource> downloadProfileData() {
	    String filename = "profileData.csv";
	    InputStreamResource file = new InputStreamResource(csvService.loadProfileData());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }


	 @GetMapping("/downloadAppliedJobs")
	  public ResponseEntity<Resource> downloadAppliedJobs() {
	    String filename = "AppliedData.csv";
	    InputStreamResource file = new InputStreamResource(csvService.loadAppliedJobsData());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	 
	 
	 @GetMapping("/downloadProfileJobs")
	  public ResponseEntity<Resource> downloadProfileJobs() {
	    String filename = "profiles.csv";
	    InputStreamResource file = new InputStreamResource(csvService.loadProfilesData());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	 
	 
	 @GetMapping("/downloadSearchCandidates")
	  public ResponseEntity<Resource> downloadSearchCandidates(@RequestParam String categoryId) {
		 
		 
		 
			List<UserProfile> profiles = new ArrayList<>();
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userRepo.findByEmail(authentication.getName());
			List<Integer> selectedProfilesIds = new ArrayList<>();
		Category category =jobCategoryRepo.findByCategoryName(categoryId);
		
		SearchCandidate candidate = new SearchCandidate();
		candidate.setJobCategory(String.valueOf(category.getId()));
//		candidate.setTimeSlot(jobAccount.getTimeSlot().getTimeSlotName());
//		candidate.setCity(jobAccount.getCity());
//		candidate.setJobType(String.valueOf(jobAccount.getJobType().getId()));
//		candidate.setState(jobAccount.getState());
//		candidate.setCity(jobAccount.getCity());
	
		
		List<OtherUserDetails> userDetails = (List<OtherUserDetails>) jobAccountCustomRepo.findProfileBySearchJob(candidate);
		
		List<SelectedProfile> applications = selectedProfileRepo.findAllBySelectedBy(user);
		for(SelectedProfile selectedProfile : applications)
		{
			selectedProfilesIds.add(selectedProfile.getUserProfile().getId());
		}
		
		for(OtherUserDetails profile : userDetails)
		{
			
			if(!selectedProfilesIds.contains(profile.getUserProfile().getId()))
			{
				if(profile.getUserProfile().getStatus()==null || profile.getUserProfile().getStatus().equals(""))
				{
					profiles.add(profile.getUserProfile());
				}
			}
		}
		
	    String filename = "profiles.csv";
	    InputStreamResource file = new InputStreamResource(csvService.loadSelectedProfilesData(profiles));

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	 
	 
//	 @GetMapping("/downloadProfileJobs")
//	  public ResponseEntity<Resource> getSearchedJobs(@RequestParam String categoryId) {
//	    String filename = "searchedJobs.csv";
//	    InputStreamResource file = new InputStreamResource(csvService.loadProfilesData());
//
//	    return ResponseEntity.ok()
//	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//	        .contentType(MediaType.parseMediaType("application/csv"))
//	        .body(file);
//	  }
	 


}
