package com.java.test;

public abstract class Father {
  public String say(){
	  return "fathers say.......";
  }
  
  public String hello(){
	  
	  return say();
	  
	  
  }
  public static void main(String[] args) {
	  Father f=new Sun();
	  
	 System.out.println(f.hello());
  }
  
  
}
