package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
