package com.howtodoinjava.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobApplicationRepo;
import com.howtodoinjava.dao.JobCategoryRepo;
import com.howtodoinjava.dao.JobRepository;
import com.howtodoinjava.dao.JobTagsRepo;
import com.howtodoinjava.dao.SavedJobsRepo;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.error.GenericException;
import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.JobApplication;
import com.howtodoinjava.model.JobCategory;
import com.howtodoinjava.model.JobTags;
import com.howtodoinjava.model.User;

@Service
public class JobService {

	@Autowired
	JobRepository jobRepository;

	@Autowired
	JobCategoryRepo categoryRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JobTagsRepo jobTagsRepo;
	
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	SavedJobsRepo savedJobsRepo;
	

	public void addJob(Job job,String userId) throws Exception {
		try {
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent()) {
				
			Set<JobTags> tags = job.getTags();
			if(tags!=null && tags.size()>0)
			{
				for(JobTags tag : tags)
				{
					JobTags jobTag = jobTagsRepo.findByName(tag.getName());
					if(jobTag==null)
					{
						JobTags savedJobTags = jobTagsRepo.save(tag);
						tag.setId(savedJobTags.getId());
					}
					else
					{
						tag.setId(jobTag.getId());
					}
				}
			}
			job.setPostedBy(user.get());
			jobRepository.save(job);
			}
			else {
				throw new GenericException("User is not present for this userId");
			}
		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}

	public List<Job> getJobsByCategory(String category) throws Exception {
		try {
			Optional<JobCategory> jobCategory = categoryRepo.findById(Integer.parseInt(category));

			if (jobCategory.isPresent()) {
				return jobRepository.findJobByCategory(jobCategory.get());
			} else {
				throw new GenericException("Job category is not available for this ID");
			}

		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}
	
	public Page<Job> getJobsByTags(List<String> tags,Map<String, Object> searchCriteria) throws Exception {
		try {
			
				return jobRepository.findJobsByTags(tags,searchCriteria);
			
		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}
	
	public List<Job> getAllJobs() throws Exception {
		try {
			
				return jobRepository.findAll();
			
		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}

	public Page<Job> getAllJobsByPage(Pageable page) throws Exception {
		try {
			
				return jobRepository.findAll(page);
			
		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}
	
	public List<Job> getJobsByCriterias(Map<String, String> criteriaMap) throws Exception {
		try {
			return jobRepository.findJobsByJobCriterias(criteriaMap);
		} catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}
	
	public Page<JobApplication> getAppliedJobs(String userId,Pageable page)throws Exception
	{
		try {
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent()) {
			return jobApplicationRepo.findAllByApplicant(user.get(),page);
			}
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
		return null;
	}
	
	public Job getJobDetail(String jobId)throws Exception
	{
		try {
			
			return jobRepository.findById(Long.parseLong(jobId)).get();
			
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
	}

}
