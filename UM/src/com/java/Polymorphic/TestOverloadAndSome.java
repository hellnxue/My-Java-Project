package com.java.Polymorphic;

import java.util.Random;
/**
 * 重载
 * 抽象类可以继承具体类，可以实现多个接口(抽象类与普通类类似)
 * 接口可以继承接口
 * 抽象类不能实例化对象，允许有abstract修饰的方法
 * 接口的成员变量和方法的修饰类型限制
 * （抽象类和接口详见com.java.TestAbstract.java和com.java.TestInterface.java）
 */
public class TestOverloadAndSome {

	/**
	 * 继承自Object的方法，每个类都有，重写Object的方法
	 */
	public String toString(){
		System.out.println("hehesdf");
		return "ok";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 测试toString()
		 */
		TestOverloadAndSome h=new TestOverloadAndSome();
		System.out.println(h);
		
		/**
		 * 测试override
		 */
		Aa a=new Ba();
		a.say("hehe");
		
		Random r=new Random(47);
		System.out.println(r.nextInt(3));
		
		Hs(1,"a");
		Hs(2,true);
		
		/**
		 * 测试抽象类
		 */
	    int abstractForVariable=Ca.i;//抽象类的静态属性的使用
	    System.out.println("抽象类的静态属性: "+abstractForVariable);
	    
	    /**
	     * 
	     * 用类型信息展示接口的属性和方法修饰类型
	     * 总结 ：接口中定义的变量----》只能是public static final类型，并且默认即为public static final类型
	     *       接口中的抽象方法----》只能是public类型的，并且默认即为public abstract类型
	     */
	    try {
			Class c=Class.forName(Aa.class.getName());
			System.out.println("是否是接口："+c.isInterface());
			System.out.println("接口属性的修饰类型："+c.getDeclaredField("v1"));
			System.out.println("接口方法的修饰类型："+c.getMethod("say", new Class[]{String.class}));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	/**
	 * 重载问题
	 * 如果几个Overloaded的方法的参数列表不一样，它们的返回者类型当然也可以不一样。但我估计你想问的问题是：如果两个方法的参数列表完全一样
	 * 它们的返回类型不能一样
	 * 不能通过方法的访问权限、放回类型、抛出的异常进行重载。如果两个方法的参数列表完全一样,方法的修饰类型不能一样，反之，可以一样
	 * @param i
	 * @param s
	 */
	public static void Hs(int i,String s){}//OK
	public static int Hs(String s){return 1;}
	public static int Hs(int i,Boolean b){ return 1;}//OK
	//public static String Hs(int i,Boolean b){ return "hehehe";}//No
	private static void Hs(int i){}//ok 访问权限变了，但相对于第一个Hs方法，这不是重载
	//private static void Hs(int i,String s){}//no

}

interface Aa{
	public int v1=10;
	public void say(String s);
	
}
class Ba implements Aa{

	@Override
	public void say(String s) {
		System.out.println("重写的say");
		
	}
	public void Bsay(){
		
	}
}
/**
 * 抽象类可以继承具体类
 * 抽象类可以看做一个普通类，but抽象类不允许创建对象
 */
abstract  class Ca extends TestOverloadAndSome{
	public static int i=100;
	
	public abstract void h();
	void f(){}
}
/**
 * 抽象类可以实现多个接口
 *抽象类可以看做一个普通类，But抽象类不允许创建对象
 */
abstract class Da implements Aa,Ea{
	//重写方法say()
	public abstract void say();
}
abstract class Fa extends TestOverloadAndSome{
	public static int u=100;
}
/**
 * 接口可以继承接口
 * 抽象类不能实例化自身对象，允许有abstract修饰的方法
 *
 */
interface Ea extends Aa{}
	




