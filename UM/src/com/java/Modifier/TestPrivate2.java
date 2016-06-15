package com.java.Modifier;
/**
 * private可以控制如可创建对象，并组织别人直接访问某个特定的构造器。
 * 任何可以肯定只是该类的一个‘助手’方法的方法，都可以把它指定为private，以确保不会在包内的其它类的地方误用它，防止改变或者删除这个方法。
 * 
 * 
 *
 */
public class TestPrivate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TestPrivate1 mf=new TestPrivate1();           //用private修饰的成员其他类中不可以访问
		TestPrivate1 tp=TestPrivate1.returnModifier();  
		System.out.println(tp);
		
		TestPrivate3 t=new TestPrivate3();
		//String name=t.name;  //用private修饰的属性和方法只能在自己类中使用，不能在其它类中使用
	}

}
