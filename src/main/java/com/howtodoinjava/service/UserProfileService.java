package com.howtodoinjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.JobCategoryRepo;
import com.howtodoinjava.dao.LocationRepository;
import com.howtodoinjava.dao.RecruiterProfileRepository;
import com.howtodoinjava.dao.SkillsRepository;
import com.howtodoinjava.dao.UserProfileRepository;
import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.error.GenericException;
import com.howtodoinjava.model.Education;
import com.howtodoinjava.model.JobCategory;
import com.howtodoinjava.model.Location;
import com.howtodoinjava.model.RecruiterProfile;
import com.howtodoinjava.model.Skills;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;
import com.howtodoinjava.model.WorkExperience;

@Service
public class UserProfileService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	RecruiterProfileRepository recruiterProfileRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	JobCategoryRepo jobCategoryRepo;
	

//	public UserProfile updateUserProfile(String userId, UserProfile profile) throws Exception {
//		try {
//			Optional<User> user = userRepository.findById(Long.parseLong(userId));
//			if (user.isPresent()) {
//
//				User profileUser = user.get();
//				if (profileUser.getUserProfile() == null) {
//					profileUser.setUserProfile(profile);
//					return userRepository.save(profileUser).getUserProfile();
//				} else {
//					UserProfile savedUserProfile = user.get().getUserProfile();
//					profile.setId(savedUserProfile.getId());
////					/profile.setEducations(savedUserProfile.getEducations());
////					profile.setWorkExperiences(savedUserProfile.getWorkExperiences());
//					for(Skills skill : profile.getTags())
//					{
//						Skills fetchedSkill = skillsRepository.findByName(skill.getName());
//						if(fetchedSkill==null)
//						{
//							Skills savedSkill = skillsRepository.save(skill);
//							skill.setId(savedSkill.getId());
//						}
//						else
//						{
//							skill.setId(fetchedSkill.getId());
//						}
//					}
//					
//					for(Location location : profile.getPrefferedLocation())
//					{
//						Location fetchedLocation = locationRepository.findByLocation(location.getLocation());
//						if(fetchedLocation==null)
//						{
//							Location savedLocation = locationRepository.save(location);
//							location.setId(savedLocation.getId());
//						}
//						else
//						{
//							location.setId(fetchedLocation.getId());
//						}
//					}
//					return userProfileRepository.save(profile);
//				}
//
//			} else {
//				throw new GenericException("User id is not available for this ID=" + userId);
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new GenericException(e.getMessage());
//		}
//	}
	
	public RecruiterProfile updateRecruiterProfile(String userId, RecruiterProfile profile,String categoryId) throws Exception {
		try {
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if (user.isPresent()) {

				User profileUser = user.get();
				if (profileUser.getRecruiterProfile() == null) {
					profileUser.setRecruiterProfile(profile);
					return userRepository.save(profileUser).getRecruiterProfile();
				} else {
					RecruiterProfile savedUserProfile = user.get().getRecruiterProfile();
					profile.setId(savedUserProfile.getId());
					 profile.setFirstName(savedUserProfile.getFirstName());
					 profile.setLastName(savedUserProfile.getLastName());
					 profile.setEmail(savedUserProfile.getEmail());
					for(Skills skill : profile.getTags())
					{
						Skills fetchedSkill = skillsRepository.findByName(skill.getName());
						if(fetchedSkill==null)
						{
							Skills savedSkill = skillsRepository.save(skill);
							skill.setId(savedSkill.getId());
						}
						else
						{
							skill.setId(fetchedSkill.getId());
						}
					}
					
					for(Location location : profile.getPrefferedLocation())
					{
						Location fetchedLocation = locationRepository.findByLocation(location.getLocation());
						if(fetchedLocation==null)
						{
							Location savedLocation = locationRepository.save(location);
							location.setId(savedLocation.getId());
						}
						else
						{
							location.setId(fetchedLocation.getId());
						}
					}
					Optional<JobCategory> category = jobCategoryRepo.findById(Integer.parseInt(categoryId));
			        profile.setCategory(category.get());
		       
					return recruiterProfileRepository.save(profile);
				}

			} else {
				throw new GenericException("User id is not available for this ID=" + userId);
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
	
	
	public UserProfile getUserProfile(String userId)throws Exception
	{
		try {
			
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent())
			{
				UserProfile profile = user.get().getUserProfile();
				if(profile==null)
				{
					throw new GenericException("Profile is not yet completed by the user");
				}
				return profile;
			}
			else
			{
				throw new GenericException("Didn't find any user by this Id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
	
	public List<Location> getLocations() throws Exception{
		try {
			List<Location> locations = (List<Location>) locationRepository.findAll();
			if(locations!=null && locations.size()>0)
			{
				return locations;
			} else {
				throw new GenericException("Unable to find locations");
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}

	}
	
	public UserProfile addEducation(Education education,String userId) throws Exception{
		try {
			
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent())
			{
				UserProfile profile = user.get().getUserProfile();
				if(profile==null)
				{
					throw new GenericException("Profile is not yet completed by the user");
				}
//				profile.getEducations().add(education);
				return userProfileRepository.save(profile);
			}
			else
			{
				throw new GenericException("Didn't find any user by this Id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
	
	public UserProfile addWorkExperience(WorkExperience workExperience,String userId) throws Exception{
		try {
			
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent())
			{
				UserProfile profile = user.get().getUserProfile();
				if(profile==null)
				{
					throw new GenericException("Profile is not yet completed by the user");
				}
//				profile.getWorkExperiences().add(workExperience);
				return userProfileRepository.save(profile);
			}
			else
			{
				throw new GenericException("Didn't find any user by this Id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}

	public UserProfile updateTags(Set<Skills> skills,String userId) throws Exception{
		try {
			
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent())
			{
				UserProfile profile = user.get().getUserProfile();
				if(profile==null)
				{
					throw new GenericException("Profile is not yet completed by the user");
				}
				for(Skills skill : skills)
				{
					Skills fetchedSkill = skillsRepository.findByName(skill.getName());
					if(fetchedSkill==null)
					{
						Skills savedSkill = skillsRepository.save(skill);
						skill.setId(savedSkill.getId());
					}
					else
					{
						skill.setId(fetchedSkill.getId());
					}
				}
				
//				profile.setTags(skills);
				return userProfileRepository.save(profile);
			}
			else
			{
				throw new GenericException("Didn't find any user by this Id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
	
	public User getUser(String userId) throws Exception{
		try {
			
			Optional<User> user = userRepository.findById(Long.parseLong(userId));
			if(user.isPresent())
			{
				User savedUser = user.get();
				if(savedUser==null)
				{
					throw new GenericException("No user found for this ID");
				}
				return savedUser;
			}
			else
			{
				throw new GenericException("Didn't find any user by this Id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
	
	public List<User> getUsers() throws Exception{
		try {
			List<User> userList = new ArrayList<User>();
			Iterable<User> users = userRepository.findAll();
			users.forEach(userList::add);
			if(userList.size()>0)
			{
				return userList;
			}
			else
			{
				throw new GenericException("Didn't find any users");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new GenericException(e.getMessage());
		}
	}
}
