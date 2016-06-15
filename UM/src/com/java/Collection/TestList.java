package com.java.Collection;

import java.util.*;


class Cookie{
	
}
public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Cookie> ls=new ArrayList<Cookie>();
		ls.add(new Cookie());
		ls.add(new Cookie());
		
		System.out.println(ls.size());
		
		//ls.removeAll(ls);
		ls.clear();
		//ls=null;
		//ls.add(new Cookie());
		System.out.println(ls);
		
		ls=null;
		
		System.out.println(ls);
		
		
		List<Integer> ls1=new LinkedList<Integer>();
		ls1.add(3);
		ls1.add(6);
		ls1.add(2);
		ls1.add(0);
		
		for(int i:ls1){
			System.out.println(i);
		}
		
		Set<Integer> st1=new HashSet<Integer>();
		st1.add(3);
		st1.add(6);
		st1.add(2);
		st1.add(0);
		System.out.println("hehe");
		for(int i:st1){
			System.out.println(i);
		}
		Student s=null;
		
		
		/**
		 * awt.List和util.List不能同时导入包到一个类中，只能一个导入包，一个指定包名创建List对象
		 */
		java.awt.List lt=new java.awt.List();
		
		/**
		 * 将list转成数组 (注意类型是包装类型，或对象类型的。不是基本类型)
		 */
		Integer[] c={};//指定一个目标类型数组
		c=st1.toArray(c);
		//或者用下面这种，重载的toArray()
		Object[] h= st1.toArray();
		for(Object j:h){
			int x=(Integer)j;
			System.out.println("heha "+(Integer)j);
		}
		System.out.println("转成的数组大小："+c.length);
		
		List<String> lss=new ArrayList<String>();
		lss.add("hehe");
		lss.add("haha");
		hj(lss);
		System.out.println("kkkkkk=== "+lss.toString());
		
	}
	
	public static void hj(List<String> lss){
		lss=new ArrayList<String>();
		lss.add("kan");
		
	}

}
interface Aa{
	public void say();
	
}
class Ba implements Aa{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}
	public void Bsay(){
		
	}
	
}