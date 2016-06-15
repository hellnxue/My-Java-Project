package com.java;
/**
 * 构造函数与关键字this的用法
 * @author liuxueping
 *
 */
public class Student {
	int i=0;
	String s="hehe";
	int j;
	
	Student(){
		
		
	}
	
   /**
    * 构造函数，有参构造，用于初始化,可以创建多个构造器
    * @param i
    */
   Student(int i){
	   System.out.println("创建就被初始化"+i);
	   
   }
   Student(String s){
	   System.out.println("第二个构造器");
   }
   
   Student(int i,String s){
	   this(i);                                   //构造函数内部调用其他构造函数可以用this，只能调用一个，并且位置在最前端
	 //this(s);
	   System.out.println("i="+i);
	   System.out.println("类自定义的S="+this.s);  //this.s代表类成员s
	   this.s=s;                                  //给类自定义的s赋新值
	   System.out.println("赋值完后的s="+s);
	   
   }
   
   public void hh(int i){
	   int h;
	   System.out.println(j);
	   //this(i);
	   
   }
   public static void main(String[] args) {
	  
	//Student ss=new Student(1,"hello");
	  Student ss=new Student(1,"hello");//new一个对象即初始化一个对象
	  System.out.println(ss);
	
}
}
