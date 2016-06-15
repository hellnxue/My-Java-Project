package com.java.Exception;

public class TestFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test1());
		System.out.println("-------------------------------------");
		System.out.println(test2());
		
	}

	static int test1(){
		int x = 1;
		try
		{
			System.out.println("ok");
			return x;
		}finally{
			
			++x;
			System.out.println("hehe="+x);
		}
	}
	/**
	 * Return并不是让函数马上返回，而是return语句执行后，将把返回结果放置进函数栈中，此时函数并不是马上返回，它要执行finally语句后才真正开始返回。
	 * @return
	 */
	static int test2(){
		try
		{
			System.out.println("try code......");
			return 1;
		}finally{
			System.out.println("finally code......");
			return 2;
		
		}
	}

}
