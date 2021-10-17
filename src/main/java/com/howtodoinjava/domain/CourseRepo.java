package com.howtodoinjava.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.entity.CourseType;

public interface CourseRepo extends JpaRepository<CourseType, Integer>{
	
	
	CourseType findByCourseTypeName(String courseTypeName);
	List<CourseType> findByCourseTypeStatus(String courseTypeStatus);
}
