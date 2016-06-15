package com.java.Interface;

interface testi1{
	
	 String say();
}

interface testi2 {
	
	 String eat();
}

interface testi3 extends testi1,testi2{
	String song();
	 
	
}

class test1 implements testi1{

	@Override
	public String say() {
		// TODO Auto-generated method stub
		return "say1";
	}
	
}

class test2 implements testi2{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "eat2";
	}
	
}

class test3  implements testi3{

	@Override
	public String say() {
		// TODO Auto-generated method stub
		return "say3";
	}

	@Override
	public String song() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return null;
	}

	 

	 

	
	
}


public class TestInterface11 {

	 public static void main(String[] args) {
		 System.out.println(new test3().eat());
	}

}
