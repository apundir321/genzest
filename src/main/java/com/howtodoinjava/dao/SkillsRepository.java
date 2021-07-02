package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.Skills;

@Repository
public interface SkillsRepository extends CrudRepository<Skills, Integer> {
	
	public Skills findByName(String name);

}
