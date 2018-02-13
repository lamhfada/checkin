package fgo.ssr.controller;

public class UserNotExist  extends Exception{
	public String getMessage() {
		return new String("此人不在名單內"); 
	}
}
