package com.anbo.test;
import java.util.Scanner;
public class TestFinal {
	
	public static void main(String[] args){
		final String aa="hello";//常量，不允许再被修改final 常量，值只能够分配一次，不能更改
		float c=11.23455f;
		int a=(int)c;
		System.out.println(a);
		int num = 10;
		int mum=20;
        if ( num == 10) { //num 在内层作用域中可用
            int num1 = num * num;
            System.out.println("num 和 num1 的值为" + num + "   " + num1);
            if(mum==20){
            	//int num1=mum*mum;
            	System.out.println(num1);
            	
            }
        }

      // System.out.println("num1 的值为" + num1);   
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入....");
        String result=sc.next();
        System.out.println(result);
		
	}
	
	public void test(){
		String p="abc";
		
		
	};

}
