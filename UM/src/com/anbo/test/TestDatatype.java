package com.anbo.test;

public class TestDatatype {
	static int j;
	static float f=11.2f;
  public static void main(String args[]){
	  byte b1=67;
	   byte b2=89;
	   byte b3=(byte)(b1+b2);
	   System.out.println(b3);
	   
	   double d2=1e200;
	   float f2=(float) d2;//错误，会产生溢出 infinity，因为转换后格式会改变
	   System.out.println(f2);
	   
	   float f=123;//没有错误，因为123是int类型，float大于int
	   System.out.println(f);
	  
  }
}
