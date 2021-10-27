package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
    List<User> findByPhoneNo(String phoneNo);
    
    User findByUserProfile(UserProfile userProfile);

    @Override
    void delete(User user);
    

}
