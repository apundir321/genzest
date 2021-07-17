package com.howtodoinjava;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.howtodoinjava.dao.JobCategoryRepo;
import com.howtodoinjava.domain.CategoryRepo;
import com.howtodoinjava.entity.Category;


@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {
	
	
	@Autowired
	CategoryRepo jobCategoryRepo;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}  
}