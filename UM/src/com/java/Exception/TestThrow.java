package com.java.Exception;

class Student{
	int i=1;
}
public class TestThrow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = null;
		
		System.out.println("--------s为null的时候-----------------------");
		h2(s);
		Student s1=new Student();
		System.out.println("--------s不为null的时候-----------------------");
		h2(s1);
		System.out.println("-------------------------------");
		h1(s);
	}
	public static void h1(Student s){
			if(s==null){
				System.out.println("抛出异常");
				throw new NullPointerException("异常内容：t=nulldddd");
			}
			System.out.println("抛完后");
		
	}
	/**
	 * 用try catch捕获抛出的异常
	 * @param s
	 */
	public static void h2(Student s){
		try{
			if(s==null){
				System.out.println("抛出异常");
				throw new NullPointerException("异常内容：t=nullssss");
			}
			System.out.println("No Exception");
		}catch(Exception e){
			System.out.println("捕获异常");
			System.out.println(e);
			e.printStackTrace();//异常追踪，可以看到是哪个类的那个地方出的异常
		}finally{
			System.out.println("llllllllllll");
		}
		System.out.println("hehehe");
		
	}
}
