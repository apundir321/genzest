package com.howtodoinjava.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.dao.UserProfileRepository;
import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.Employer;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.entity.SearchCandidate;
import com.howtodoinjava.entity.SearchJobEarning;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.entity.TimeSlot;
import com.howtodoinjava.model.JobEarning;
import com.howtodoinjava.model.UserProfile;


@Repository
@Transactional
public class JobAccountCustomRepoImpl implements JobAccountCustomRepo {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	JobAccountRepo JobAccountRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	EmployerRepo employerRepo;
	
	@Autowired
	JobTypeRepo jobTypeRepo;
	
	@Autowired
	TimeSlotRepo timeSlotRepo;
	
	@Autowired
	UserProfileRepository userRepo;
	
	@Override
	public List<JobAccount> findJobsByJobCriterias(SearchJobs searchJob) {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<JobAccount> cq = cb.createQuery(JobAccount.class);
		    
		    Root<JobAccount> job = cq.from(JobAccount.class);
		    List<Predicate> predicates = new ArrayList<>();
		    
		    if (!StringUtils.isEmpty(searchJob.getJobCategory())) {
		    	Category category = categoryRepo.findById(Integer.parseInt(searchJob.getJobCategory())).get();
		        predicates.add(cb.equal(job.get("category"), category));
		    }
		    
		    if (!StringUtils.isEmpty(searchJob.getEmployerName())) {
		    	Optional<Employer> employer = employerRepo.findById(Integer.parseInt(searchJob.getEmployerName()));
		        predicates.add(cb.equal(job.get("employer"), employer.get()));
		    }
		    if (!StringUtils.isEmpty(searchJob.getJobType())) {
		    	JobType jobType = jobTypeRepo.findById(Integer.parseInt(searchJob.getJobType())).get();
		        predicates.add(cb.equal(job.get("jobType"), jobType));
		    }
		    if (!StringUtils.isEmpty(searchJob.getTimeSlot())) {
		    	TimeSlot timeSlot = timeSlotRepo.findById(Integer.parseInt(searchJob.getTimeSlot())).get();
		        predicates.add(cb.equal(job.get("timeSlot"), timeSlot));
		    }
		    
		    if (!StringUtils.isEmpty(searchJob.getState())) {
		        predicates.add(cb.equal(job.get("state"), searchJob.getState()));
		    }
		    if (!StringUtils.isEmpty(searchJob.getCity())) {
		        predicates.add(cb.equal(job.get("city"), searchJob.getCity()));
		    }
		    if(searchJob.getDateFrom() != null)
		    {
		    	try {
					
					predicates.add(cb.greaterThanOrEqualTo(job.get("jobDate"),searchJob.getDateFrom()));
		    	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    
		    if(searchJob.getDateTo() != null)
		    {
		    	try {
					
					predicates.add(cb.lessThanOrEqualTo(job.get("jobDate"),searchJob.getDateTo()));
		    	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    cq.where(predicates.toArray(new Predicate[0]));

		    return em.createQuery(cq).getResultList();

	}

	@Override
	public List<JobAccount> findJobsByCategory(Category category) {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<JobAccount> cq = cb.createQuery(JobAccount.class);
		    
		    Root<JobAccount> job = cq.from(JobAccount.class);
		    List<Predicate> predicates = new ArrayList<>();
		    	if(category!=null)
		    	{
		    		predicates.add(cb.equal(job.get("category"), category));
		    	}
		        cq.where(predicates.toArray(new Predicate[0]));

			    return em.createQuery(cq).getResultList();
		    
		    
	}
	
	
	public   List<Object[]> findJobAcountByCateory() {
	      System.out.println("-- Employee count group by dept --");
	      
	      CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	      CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
	      Root<JobAccount> jobAccountRoot = query.from(JobAccount.class);
	      query.groupBy(jobAccountRoot.get("category"));
	      query.multiselect(jobAccountRoot.get("category"), criteriaBuilder.count(jobAccountRoot));
	      TypedQuery<Object[]> typedQuery = em.createQuery(query);
	      List<Object[]> resultList = typedQuery.getResultList();
	      return resultList;
	  }
	
	
//	@Override
	public List<UserProfile> findProfileByProfileCriterias(SearchCandidate searchCandidate) {
		// TODO Auto-generated method stub
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<UserProfile> cq = cb.createQuery(UserProfile.class);
		    
		    Root<UserProfile> job = cq.from(UserProfile.class);
		    List<Predicate> predicates = new ArrayList<>();
		    
		    if (!StringUtils.isEmpty(searchCandidate.getJobCategory())) {
		    	Category category = categoryRepo.findById(Integer.parseInt(searchCandidate.getJobCategory())).get();
		        predicates.add(cb.equal(job.get("category"), category));
		    }
		    
		    if (!StringUtils.isEmpty(searchCandidate.getEmployerName())) {
		    	Optional<Employer> employer = employerRepo.findById(Integer.parseInt(searchCandidate.getEmployerName()));
		        predicates.add(cb.equal(job.get("employer"), employer.get()));
		    }
		    if (!StringUtils.isEmpty(searchCandidate.getJobType())) {
		    	JobType jobType = jobTypeRepo.findById(Integer.parseInt(searchCandidate.getJobType())).get();
		        predicates.add(cb.equal(job.get("jobType"), jobType));
		    }
		    if (!StringUtils.isEmpty(searchCandidate.getTimeSlot())) {
		    	TimeSlot timeSlot = timeSlotRepo.findById(Integer.parseInt(searchCandidate.getTimeSlot())).get();
		        predicates.add(cb.equal(job.get("timeSlot"), timeSlot));
		    }
		    if (!StringUtils.isEmpty(searchCandidate.getState())) {
		        predicates.add(cb.equal(job.get("state"), searchCandidate.getState()));
		    }
		    if (!StringUtils.isEmpty(searchCandidate.getCity())) {
		        predicates.add(cb.equal(job.get("city"), searchCandidate.getCity()));
		    }
		    if (!StringUtils.isEmpty(searchCandidate.getGender())) {
		        predicates.add(cb.equal(job.get("gender"), searchCandidate.getCity()));
		    }
		    cq.where(predicates.toArray(new Predicate[0]));

		    return em.createQuery(cq).getResultList();

	}

	@Override
	public List<JobEarning> findJobEarningByProfileCriteria(SearchJobEarning searchJobEarning) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 CriteriaBuilder cb = em.getCriteriaBuilder();
				    CriteriaQuery<JobEarning> cq = cb.createQuery(JobEarning.class);
				    
				    Root<JobEarning> jobEarning = cq.from(JobEarning.class);
				    List<Predicate> predicates = new ArrayList<>();
				    
				    if (!StringUtils.isEmpty(searchJobEarning.getJobId())) {
				    	JobAccount jobAccount = JobAccountRepo.findById(Integer.parseInt(searchJobEarning.getJobId())).get();
				        predicates.add(cb.equal(jobEarning.get("jobAccount"), jobAccount));
				    }
				    
				    if (!StringUtils.isEmpty(searchJobEarning.getEmployerName())) {
				    	Optional<Employer> employer = employerRepo.findById(Integer.parseInt(searchJobEarning.getEmployerName()));
				        predicates.add(cb.equal(jobEarning.get("jobAccount").get("employer"), employer.get()));
				    }
				    
				    if(searchJobEarning.getDateFrom() != null)
				    {
				    	try {
							
							predicates.add(cb.greaterThanOrEqualTo(jobEarning.get("presentDate"),searchJobEarning.getDateFrom()));
				    	} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	
				    }
				    
				    if(searchJobEarning.getDateTo() != null)
				    {
				    	try {
							
							predicates.add(cb.lessThanOrEqualTo(jobEarning.get("presentDate"),searchJobEarning.getDateTo()));
				    	} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	
				    }

				    
				    cq.where(predicates.toArray(new Predicate[0]));

				    return em.createQuery(cq).getResultList();
	}


}
