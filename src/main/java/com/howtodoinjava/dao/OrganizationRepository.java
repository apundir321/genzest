package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	public Organization findByName(String orgName);

}
