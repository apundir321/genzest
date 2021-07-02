package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserLocation;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
