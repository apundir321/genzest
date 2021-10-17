package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
    List<User> findByPhoneNo(String phoneNo);

    @Override
    void delete(User user);
    

}
