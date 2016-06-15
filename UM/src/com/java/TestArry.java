package com.java;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组的初始化
 * 编译器不能指定数组的大小
 * 在Java中可以将一个数组赋值给另一个数组，其实真正做的只是复制了一个引用
 *
 */
public class TestArry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1={1,2,3,4,5};	//初始化数组，用花括号括起来（相当于new）
		int a2[];     			//定义一个数组的引用
		System.out.println(a1[0]);
		
		a2=a1;                  //复制数组a1的引用给数组a2
		for(int i=0;i<a2.length;i++){
			a2[i]=a2[i]+1;
		}
		for(int i=0;i<a1.length;i++){
			
			System.out.println("a1="+a1[i]);//a2和a1是相同数组的别名,通过a2做的修改在a1中可以看到

		}
		
		System.out.println("---------初始化数组的大小--------------");
		arrayClassObj();
		System.out.println("---------初始化对象数组--------------");
		arrayInit();
	}
	//初始化数组的大小
	public static void arrayClassObj(){
		Random rd=new Random(47);
		System.out.println(rd);
		Integer[] a=new Integer[rd.nextInt(20)]; //用new初始化数组的大小,此时的a只是一个引用
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(20);                 //运行完这一行，数组a的初始化才算完成
		}
		System.out.println(Arrays.toString(a));
		
	}
	
   //初始化对象数组
   public static void arrayInit(){
	   Integer[] a={
			   new Integer(1),
			   new Integer(2),
			   3
	   };
	   
	   Integer[] b=new Integer[]{
			   new Integer(1),
			   new Integer(2),
			   3,
			   
	   };
	   System.out.println(Arrays.toString(a)+"   a ="+a[1]);
	   System.out.println(Arrays.toString(b)+"   b ="+b[1]);
   }

}
