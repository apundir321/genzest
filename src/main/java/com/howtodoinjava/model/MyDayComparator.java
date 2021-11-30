package com.howtodoinjava.model;

import java.util.Comparator;

import com.howtodoinjava.entity.DayPreference;

public class MyDayComparator implements Comparator<DayPreference>
{
	   
    public int compare(DayPreference s1, DayPreference s2)
    {
        return s1.getDay().compareTo(s2.getDay());
    }
}