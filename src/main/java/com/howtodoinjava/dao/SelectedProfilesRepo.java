package com.howtodoinjava.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.entity.SelectedProfile;
import com.howtodoinjava.model.User;

@Repository
public interface SelectedProfilesRepo extends JpaRepository<SelectedProfile,Long>{
	
	public List<SelectedProfile> findAllBySelectedBy(com.howtodoinjava.model.User user);
	

}
