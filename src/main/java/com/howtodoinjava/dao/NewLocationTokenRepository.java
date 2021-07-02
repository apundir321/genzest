package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.NewLocationToken;
import com.howtodoinjava.model.UserLocation;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
