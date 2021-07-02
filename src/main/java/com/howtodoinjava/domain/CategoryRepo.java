package com.howtodoinjava.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
