package com.java.Class;

import java.lang.reflect.*;
/**
 * 用Class操作类
 *
 */

public class TestClass3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       People p=new People();		
       p.setId(1);
       p.setName("蜡笔小新");
       p.setAge(20);
       
       //用反射获得或者修改People的值
       
       try {
		Class cl=People.class;
		Method[] m1=cl.getDeclaredMethods();
		for(int i=0;i<m1.length;i++){
			System.out.println(m1[i]);
		}
		//获得name的值
		Method m2=cl.getDeclaredMethod("getName", null);
		String s=(String) m2.invoke(p, null);
		System.out.println(s);
		
		//获得age
		Method m3=cl.getMethod("getAge", null);
		Integer age=(Integer) m3.invoke(p, null);
		System.out.println(age);
		
		//修改name
		Method m4=cl.getMethod("setName", String.class);
		m4.invoke(p, "雪宝");
		//重新获得name
		Method m5=cl.getDeclaredMethod("getName", null);
		String rname=(String) m5.invoke(p,null );
		System.out.println(rname);
		
		
	} catch (Throwable e) {
		e.printStackTrace();
	}
	}

}
class People{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
