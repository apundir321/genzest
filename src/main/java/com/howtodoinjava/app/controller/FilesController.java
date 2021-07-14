package com.howtodoinjava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.howtodoinjava.service.CSVService;

@Controller
public class FilesController {
	
	@Autowired
	CSVService csvService;
	
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


}
