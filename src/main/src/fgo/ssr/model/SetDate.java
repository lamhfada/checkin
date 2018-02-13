package fgo.ssr.model;

import java.util.LinkedList;


import java.io.*;

public class SetDate {
	public void datecheckin(oneDay OD) throws IOException{
		DateDAO dDAO = new DateDAO();
		dDAO.dateCheckIn(OD);
	}
	
	public boolean checkExist(String name) throws IOException{
		boolean exist ;
		DateDAO dDAO = new DateDAO();
		exist = dDAO.Exist(name);
		return exist;
	}
	
	public LinkedList<String> getAllday(String name){
		LinkedList<String> allday = new LinkedList<>();
		DateDAO dDAO = new DateDAO();
		allday = dDAO.getAllday(name);
		
		return allday;
	}
}
