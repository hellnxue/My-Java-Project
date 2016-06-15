package com.anbo.test;

public class TestTryFinally {
  public static void main(String args[]){
	  int i;
	  TestTryFinally t  = new  TestTryFinally();
		int  b  =  t.get();
		System.out.println(b);
		int a=t.test();
		System.out.println(a);
	  
  }
  public int  get()
	{
		try
		{	 System.out.println("try");
			return 1 ;
		}
		finally
		{	System.out.println("finally");
			return 2 ;
		}
	}
 public static int test()
	{
		int x = 1;
		try
		{
			return x;
		}
		finally
		{
			++x;
			System.out.println(x);
			return x;
		}
	}
  
}
