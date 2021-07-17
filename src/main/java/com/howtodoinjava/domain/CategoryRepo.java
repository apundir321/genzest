package com.howtodoinjava.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	 @Query(value="SELECT * FROM genzest.states where country_id= :countryId", nativeQuery=true)
	    List<Object[]> getStatesByCountryId(String countryId);
	    
	    
	    @Query(value="SELECT * FROM genzest.cities where state_id IN (SELECT state_id FROM genzest.states WHERE state_name= :state_id)", nativeQuery=true)
	    List<Object[]> getCitiesByState(String state_id);
	    
	    @Query(value="SELECT * FROM genzest.cities where city_name= :cityName", nativeQuery=true)
	    List<Object[]> getCityByCityName(String cityName);
	    
	    
	    Category findByCategoryName(String categoryName);

}
