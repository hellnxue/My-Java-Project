package com.java.Class;

import java.net.Proxy;

interface itf1{}
interface itf2{}
class Animal{
	
	int y=99;
	static final int yy=10;
	final  int u=100;
	static int k=90;
	Animal(){
		System.out.println("加载Animal类了");
	}
	/**
	 * static域的代码只加载一次
	 */
	static{
		System.out.println("Animal的static字句");
		
	}
	public  void h(){
		System.out.println("function for Animal");
	}
	
	public static   void j(){}
}
class Brid extends Animal implements itf1,itf2{
	private int op=10;
	
	Brid(){
		System.out.println("加载Brid类了");
	}
	static{
		System.out.println("Brid的static字句");
	}
	public void h(){
		System.out.println("function for Brid"+super.yy);
	}
	public static  void j(){}
}
public class TestClass {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args){
		
		

		Animal cl=new Animal();
		showName(cl);
		
		System.out.println(int.class);
		
		int[] o={};
		
		System.out.println(int[].class);

		Animal a=new Animal();
		
		Class c=null;
		try {
			 c=Class.forName("com.java.Class.Brid");
			 System.out.println("打印Brid的类型信息--------------------");
			 printInfo(c);
			 
			 System.out.println("打印Brid实现的接口的类型信息-------------------");
			 for(Class c1:c.getInterfaces()){
				 printInfo(c1);
			 }
			 /**
			  * getSuperclass();得到调用Class的基类的Class
			  */
			 Class c2=c.getSuperclass();
			 System.out.println("打印Brid实现的父类的类型信息-------------------");
			 printInfo(c2);
			 Object ob=null;
			 
			 /**
			  * newInstance();//创建此Class对象所表示的类的一个实例,得到的是Object类型的，需要转换成相应的类型才能使用
			  */
			  ob=c2.newInstance();
			  
			  Animal al=(Animal)ob;
			  
			 System.out.println("ob="+ob+"    al="+al+"   ");
			 al.h();
			 System.out.println("====打印父类的类型信息=================================");
			 printInfo(ob.getClass());
			
			 /**
			  * 创建实例对象的另一种方法
			  */
			 Animal aa=Animal.class.newInstance();
			 aa.h();
			 System.out.println(aa.y);
			 
			 /**
			  * 创建实例对象的另一种方法
			  */
			 System.out.println("测试创建实例对象---------------------------------------------------");
			 
			 Brid b=(Brid)c.newInstance();
			 
			 b.h();
			 
			 String s="";
			 
			 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void showName(Object o){
		System.out.println(o.getClass().getName());
	}
	
   public static void printInfo(Class c){
	   /**
		  * getName():返回全限定类名（即包名和类名）
		  * getSimpleName()：返回不包含包名的类名
		  * getCanonicalName():全限定类名
		  */
		 System.out.println("c.getName()="+c.getName()+"    c.getSimpleName()="+c.getSimpleName()+"    c.getCanonicalName()="+c.getCanonicalName());
		 System.out.println("是否是接口="+c.isInterface());
   }

}
