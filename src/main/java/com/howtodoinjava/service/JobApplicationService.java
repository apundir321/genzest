package com.howtodoinjava.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobApplicationRepo;
import com.howtodoinjava.dao.JobRepository;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.error.GenericException;
import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.JobApplication;
import com.howtodoinjava.model.User;

@Service
public class JobApplicationService {

	@Autowired
	JobApplicationRepo jobApplicationRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JobRepository jobRepository;

	public void applyJob(String userId,String jobId)throws Exception
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
			JobApplication application = new JobApplication();
			application.setJob(job.get());
			application.setApplicant(user.get());
			application.setApplicationDate(new Date());
			jobApplicationRepo.save(application);
		}
		else
		{
			throw new GenericException("User Id not found");
		}
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
		
		
	}

}
