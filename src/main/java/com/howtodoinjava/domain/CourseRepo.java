package com.howtodoinjava.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.CourseType;
import com.howtodoinjava.entity.JobType;

public interface CourseRepo extends JpaRepository<CourseType, Integer>{

}
