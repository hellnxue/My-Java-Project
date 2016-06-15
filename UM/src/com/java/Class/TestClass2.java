package com.java.Class;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * java反射机制
 * 
 *
 */
public class TestClass2 {
	
	private String name;
	private int age;
	
	public void say(){
		System.out.println("呵呵");
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class c=null;
		
		try {
			c=c.forName(TestClass2.class.getName());
			
			
			Field[] f=c.getDeclaredFields();//返回所有的声明字段
			for(int i=0;i<f.length;i++){
				System.out.println("变量成员： "+f[i].getName()+"  变量成员类型： "+f[i].getType());
			}
			
			System.out.println("------------------------返回指定的class声明字段：");
			
			/**
			 * 单个获得属性类型信息 c.getDeclaredField("name")
			 * c.getField("name")->这个会报错，不知为啥
			 */
			System.out.println("属性name的具体信息1： "+c.getDeclaredField("name"));
			//System.out.println("属性name的具体信息： "+c.getField("name"));
			
			System.out.println("------------------------返回指定的class声明方法：");
			System.out.println("获得指定方法的类型信息一：getName方法："+c.getMethod("getName", null)+"  setName方法："+c.getMethod("setName", new Class[]{String.class}));
			System.out.println("获得指定方法的类型信息二："+c.getDeclaredMethod("setName", c.getDeclaredField("name").getType()));
			
			Method[] m=c.getDeclaredMethods();//返回所有的声明方法
			for(int i=0;i<m.length;i++){
				System.out.println("方法成员： "+m[i].toString());
			}
			
			TestClass2 t=new TestClass2();
			t.setName("蜡笔小新");
			test1(t);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Throwable e) {
		 System.err.println(e);
		 }


	}
	 /**
	  * 通过java反射机制动态获取或修改属性的值
	  * @param tc
	  */
	public static void test1(TestClass2 tc){
		Class c=null;
		try {
			c=Class.forName(tc.getClass().getName());
			/**
			 * getMethod方法第一个参数指定一个需要调用的方法名称，第二个参数是需要调用方法的参数类型列表，如无参数可以指定null，该方法返回一个方法对象　
			 */
			Method m1=c.getMethod("getName", null);
			Method m2=c.getMethod("setName", new Class[]{String.class});
			//动态取得属性name的值
			String name=(String) m1.invoke(tc, null);
			
			System.out.println("修改前的值："+name);
		    //动态修改name值
			m2.invoke(tc, "铅笔小新");
			String name2=(String) m1.invoke(tc, null);
			System.out.println("修改后的值："+name2);
			
			
			
			
		} catch (Throwable e) {
			 System.err.println(e);
		}

	}

}
