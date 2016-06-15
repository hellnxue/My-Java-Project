package com.java;
/**
 * 方法重载:每个重载的方法都必须有一个独一无二的参数列表，甚至参数顺序的不同也可区分两个方法
 * @author liuxueping
 *
 */
public class TestOverload {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 f("first",1);
		 f(1,"last");
		
	}
	
	public static void f(String s,int i){
		System.out.println("String: "+s+"  i  "+i);
	}
	
	public static void f(int i,String s){
		System.out.println("int: "+"i: "+i+"  s  "+s);
	}
	
	/**
	 * 不能以返回值来区别重载方法
	 * @return
	 */
	
//	public static int h(){
//		
//		return 1;
//	}
//	
//	public static void h(){
//		
//	}

}
