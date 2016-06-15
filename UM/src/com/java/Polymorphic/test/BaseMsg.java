package com.java.Polymorphic.test;

public class BaseMsg {
   private String username;

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toXml(){
		StringBuilder stb=new StringBuilder();
		stb.append("hello").append("BaseMsg");
		return stb.toString();
		
	}
   public String toString(){
	   
	   return toXml();
   }
}
