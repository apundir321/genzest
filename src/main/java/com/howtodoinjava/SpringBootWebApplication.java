package com.howtodoinjava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.domain.JobAccountRepo;
import com.howtodoinjava.entity.JobAccount;

@EnableScheduling
@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {
	
	
	@Autowired
	CategoryRepo jobCategoryRepo;
	
	@Autowired
	JobAccountRepo jobAccountRepo;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}  
	
	
	@Scheduled(cron = "0 0 7 * * ?")
	public void deleteExpiredJobs()
	{
		List<JobAccount> accounts = (List<JobAccount>) jobAccountRepo.findAllValid();
		for(JobAccount account: accounts)
		{
			System.out.println("Deleting "+account.getJobName());
			account.setStatus("Deleted");
			jobAccountRepo.save(account);
		}
		System.out.println("deleting jobs");
	}
}