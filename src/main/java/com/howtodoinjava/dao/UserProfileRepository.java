package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;

import com.howtodoinjava.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {

}
