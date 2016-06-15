package com.java;
/**
 * 常量表示
 * 16进制、8进制表示，以及char、byte、short的范围，后缀表示等
 * @author liuxueping
 *
 */
public class TestConstant {
  public static void main(String[] args) {
	  
	//16进制计数法  
	int i1=0x9fffffff;//16进制数（由0x或0X为前缀，后面跟随0-9或小写(或大写)的a-f表示）。
	System.out.println(i1);
	System.out.println("i1 ="+Integer.toBinaryString(i1));//转成二进制
	System.out.println("i1 ="+Long.toBinaryString(i1));//转成二进制
	
	int i2=0X2F;
	System.out.println(i2);
	
	//8进制计数法  
	int i3=0167;//八进制（由前缀0以及后续的0-7的数字来表示）
	System.out.println("i3== "+i3);
	System.out.println("i3== "+Long.toBinaryString(i3));
	
	char i4=0xffff;//char的最大范围
	System.out.println(Integer.toBinaryString(i4));
	
	byte b=0x7f;//byte的最大范围
	System.out.println(Integer.toBinaryString(b));
	
	short c=0x7fff;//byte的最大范围
	System.out.println(Integer.toBinaryString(c));
	
    long l1=1l;
    long l2=2L;
    long l3=100;
    
	float f1=1;
	float f2=100f;
	float f3=100F;
	//float f4=10.0;  //10.0默认为double类型，需要加上f标明是float类型的
	
	
	System.out.println("f1= "+f1);
 
    double d1=1;
    double d2=10d;
    double d3=10D;
    
    System.out.println("d2= "+d2);
    
    //指数计数法
    float ff=2e2f;//相当于2*10*10 及2乘以10的2次方，由于编译器会把指数当做双精度的double来处理，所以，要加上后缀f
    System.out.println(ff);
    
     //舍入
      double dd=29.7;
	 
	 System.out.println((int)dd);
	 System.out.println(Math.round(dd));
	 System.out.println(Math.round(-29.7));
	 
	 /**
	  * Math.floor 向下取整，返回一个小于等于该参数，并等于一个整数的数字，若参数为整数，那么值直接等于这个数字
	  * Math.round(x) 为Math.floor(x+0.5)的值
	  */
	 System.out.println(Math.floor(-29));
	 System.out.println(Math.floor(-29.2));
	 System.out.println(Math.floor(29.2));
	 
  }
}
