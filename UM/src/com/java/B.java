package com.java;

public class B {
	
	private String s;
	private B a;
	public void print(  String s, B a ){
		System.out.println(s);
		
		s = "World";
		
		
		this.a.s = s;
		
		
		System.out.println("this.s="+this.s);
		System.out.println("this.a.s="+this.a.s);
	}
}
