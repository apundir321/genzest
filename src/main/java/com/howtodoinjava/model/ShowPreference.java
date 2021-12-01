package com.howtodoinjava.model;

import java.util.List;

public class ShowPreference implements Comparable<String>{
	
	private String dayName;
	private List<String> slots;
	
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	public List<String> getSlots() {
		return slots;
	}
	public void setSlots(List<String> slots) {
		this.slots = slots;
	}
	@Override
	public int compareTo(String o) {
		return this.dayName.compareTo(o);
	}

}
