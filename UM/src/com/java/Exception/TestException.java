package com.java.Exception;

public class TestException {

	public static void main(String[] args) {
		try{

	        throw new Exception("抛着玩的。") ; // 人为抛出

		 }catch(Exception e){
		
		        System.out.println(e.getMessage()) ;
		        e.printStackTrace();//异常追踪 哪个类的哪一行代码出的异常
		
		 }

	}

}
