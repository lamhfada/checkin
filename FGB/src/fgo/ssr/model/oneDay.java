package fgo.ssr.model;

import java.util.*;

public class oneDay {
	private Date day = new Date();
	private String name;
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

    
	public oneDay(){
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(Date date) {
		this.day = date;
	}
	public String getName() {
		return name;
	}
	
	public String getDate() {
		String currentTime = sdf.format(day);
		return currentTime;
	}
	
	
}
