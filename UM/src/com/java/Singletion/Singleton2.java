package com.java.Singletion;


/**
 * 懒汉式加载（推荐使用）
 * @author wm
 *
 */
public class Singleton2 {
	
   //初始为null，暂不实例化
   private static Singleton2 singleton2=null;
   
   //私有的构造子(构造器,构造函数,构造方法)
   private Singleton2(){
	   
   }
  //公开，静态的工厂方法，需要使用时才去创建该单体，延迟类实例化的时间，提高项目的运行效率
   public static Singleton2 getInstance(){
	   if(singleton2==null){
		   singleton2=new Singleton2();
	   }
	   return singleton2;
   }
}
