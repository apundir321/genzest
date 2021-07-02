package com.howtodoinjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobCategoryRepo;
import com.howtodoinjava.error.GenericException;
import com.howtodoinjava.model.JobCategory;

@Service
public class JobCategoryService {

	@Autowired
	private JobCategoryRepo jobCategoryRepo;
	
	
	public JobCategory addCategory(JobCategory category)throws Exception
	{
		JobCategory jCategory = null;
		try {
			JobCategory jobCategory = jobCategoryRepo.findByJobCategoryName(category.getJobCategoryName());
			if(jobCategory!=null)
			{
				throw new Exception("JobCategory already Exists");
			}
			jCategory = jobCategoryRepo.save(category);
			
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}
		return jCategory;
	}
	
	public List<JobCategory> getCategories()throws Exception
	{
		List<JobCategory> categories = null;
		try {
			return jobCategoryRepo.findAll();
		}catch (Exception e) {
			throw new GenericException(e.getMessage());
		}		
	}
	
	public Optional<JobCategory> getCategoryById(int categoryId)
	{
		return jobCategoryRepo.findById(categoryId);
	}
}
