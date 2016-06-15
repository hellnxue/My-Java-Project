package com.java.Collection;

import java.util.ArrayList;

/**
 * 范型
 * 
 *
 */
class Apple{
	private static long counter;
	private final long id=counter++;
	public long id(){
		return id;
	}
}
class Orange{
}

class Hes1 extends Apple{}

public class TestGeneric {

	
	public static void main(String[] args) {
		
		/**
		 * 不使用泛型的例子
		 */
		ArrayList al=new ArrayList();
		for(int i=0;i<3;i++){
			al.add(new Apple());
			//al.add(new Orange());   //会出现运行错误java.lang.ClassCastException
		}
		
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
			Apple a=(Apple) al.get(i);
			//Orange o= al.get(i);  编译报错
		}
		
		
		/**
		 * 使用泛型的例子
		 */
		ArrayList<Apple> al1=new ArrayList<Apple>();
		for(int i=0;i<3;i++){
			al1.add(new Apple());
		}
		
		for(int i=0;i<al.size();i++){
			Apple a= al1.get(i);
		}
		
		/**
		 * 向上转型也可以像作用于其他类型一样作用于泛型
		 */
		ArrayList<Apple> al2=new ArrayList<Apple>();
		for(int i=0;i<3;i++){
			al2.add(new Hes1());
		}
		
		System.out.println("jhk="+al2);
	}

}
