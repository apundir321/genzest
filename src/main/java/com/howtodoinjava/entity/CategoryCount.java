package com.howtodoinjava.entity;

public class CategoryCount {
    public String category;
    public long value;
	public String getCategory() {
		return category;
	}
	public CategoryCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "CategoryCount [category=" + category + ", value=" + value + "]";
	}
  }
