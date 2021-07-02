package com.howtodoinjava.model;

import com.howtodoinjava.entity.TimeSlot;

public class JobTimeSlot {
	
	TimeSlot timeSlot;
	int jobId;
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	

}
