package com.howtodoinjava.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobRepository;
import com.howtodoinjava.dao.SavedJobsRepo;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.error.GenericException;
import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.SavedJobs;
import com.howtodoinjava.model.User;

@Service
public class SavedJobsApplicationService {

	@Autowired
	SavedJobsRepo savedJobsRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JobRepository jobRepository;
	

	public void saveJob(String userId,String jobId)throws Exception
	{
		try {
		Optional<User> user = userRepository.findById(Long.parseLong(userId));
		if(user.isPresent())
		{
			Optional<Job> job = jobRepository.findById(Long.parseLong(jobId));
			if(!job.isPresent())
			{
				throw new GenericException("Job Id not found");
			}
			SavedJobs application = new SavedJobs();
			application.setJob(job.get());
			application.setApplicant(user.get());
			application.setApplicationDate(new Date());
			savedJobsRepo.save(application);
		}
		else
		{
			throw new GenericException("User Id not found");
		}
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
		
		
	}
	
	public List<SavedJobs> getSavedJobs(String userId)throws Exception
	{
		try {
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent()) {
			return savedJobsRepo.findAllByApplicant(user.get());
			}
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
		return null;
	}
	
	public SavedJobs getSavedJobDetail(String userId,String jobId)throws Exception
	{
		try {
			return savedJobsRepo.findSavedJobByUserIdAndJobId(userId, jobId);
			
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}

}
