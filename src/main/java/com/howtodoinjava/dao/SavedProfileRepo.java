package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.SavedProfile;

@Repository
public interface SavedProfileRepo extends JpaRepository<SavedProfile,Integer>{

}
