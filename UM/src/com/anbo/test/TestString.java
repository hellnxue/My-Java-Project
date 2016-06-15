package com.anbo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.anbo.test.testExtends.GoodStudent;

public class TestString {
	static String aac;//默认值是null
	static int aab;//默认值是0
	static Integer aad;//默认值是null
   public static void main(String args[]){
	
	   /*String a="abc";
	   int b=10;
	   Integer c=12;
	   String sp[]=a.split("a");
	   
	   System.out.println(a+c);
	   
	  
	  System.out.println(a.split("b")[0]+a.split("b")[1]);
	  
	  GoodStudent gs=new GoodStudent("小新", 12);
	  gs.sayHello();
	  
	  System.out.println(a.length());//字符串长度
	  System.out.println(sp.length);//数组长度
	  System.out.println(a.hashCode());
	  System.out.println("------------String-------------------");
	  String a1="hello";
	  String a2="hello";
	  System.out.println(a1==a2);
	  System.out.println(a1.equals(a2));
	  
	  System.out.println("--------------------区别---------------------");
	  
	  

	  String string1 = new String("苹果是一种水果");
	  String string3 = new String("苹果是一种水果");
      String string4="苹果是一种水果";
	  System.out.println(string1==string3);//检查String1和string3是否指向同一个对象,即两个变量对应的内存的数值是否相同
	  System.out.println(string1.equals(string3));//检查两个的字符串内容是否相同
	  System.out.println(string1==string4);
	  System.out.println("-------------随机数生成器------------------");
	  Random rd=new Random();
	  System.out.println(rd.nextInt(100));
	  
	  System.out.println("--------------时间-----------------");
	  Calendar objCalendar = Calendar.getInstance();
      // 显示 Date 和 Time 的组成部分
      System.out.println("\nDate 和 Time 的组成部分：");
      System.out.println("年：" + objCalendar.get(Calendar.YEAR));
      System.out.println("月： " + objCalendar.get(Calendar.MONTH));
      System.out.println("日：" + objCalendar.get(Calendar.DATE));
      System.out.println("小时：" + objCalendar.get(Calendar.HOUR));
      System.out.println("分钟：" + objCalendar.get(Calendar.MINUTE));
      System.out.println("秒：" + objCalendar.get(Calendar.SECOND));
      
      
      Date date=new Date();
      SimpleDateFormat simp=new SimpleDateFormat();
      String d=simp.format(date);
      System.out.println(d);
      
      char as='新';
      System.out.println("----------------------------------------");  
      String s1="a";
      String s2=s1+"b";
      String s3="a"+"b";
      String s4="ab";
      String s5=new String("ab");
      System.out.println(s2=="ab");
      System.out.println(s2==s3);
      System.out.println(s2.equals("ab"));
      System.out.println(s2.equals("Ab"));
      System.out.println(s3=="ab");
      System.out.println(s3==s4);
      System.out.println(s4==s5);
      System.out.println(s2);
      System.out.println(s3);
      
      System.out.println("------------------各种类型的默认值----------------------"); 
      System.out.println(aac==null?true:false);
      System.out.println(aab);
      System.out.println(aad);
      
      
      
      System.out.println("------------------String 默认值----------------------");
      System.out.println(aac);
      String s="hello";
       s="java";
       System.out.println(s);*/
	   
	   //将一串数字整成数组存储 例如"0102050811"，存为数组{01,02,05,08,11}
	   System.out.println("11".substring(0, 2));
	   
       String sb="0102050811";
       System.out.println(sb.length()/2);
       String sbs[]=new String[sb.length()/2];
       int j=0;
       for(int i=0;i<sb.length()/2;i++){
    	   System.out.println(j);
    	   sbs[i]=sb.substring(j, j+2);
    	   j=j+2;
    	  
       }
      
       for(String ssb:sbs){
    	   System.out.println("hehe"+ssb);
       }
       
   }
}
