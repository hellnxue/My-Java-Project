package com.java.Exception;

public class TestException {

	public static void main(String[] args) {
		try{

	        throw new Exception("������ġ�") ; // ��Ϊ�׳�

		 }catch(Exception e){
		
		        System.out.println(e.getMessage()) ;
		        e.printStackTrace();//�쳣׷�� �ĸ������һ�д�������쳣
		
		 }

	}

}
