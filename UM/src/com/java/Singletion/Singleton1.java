package com.java.Singletion;
/**
 * 饿汉式加载（不太推荐）
 * @author wm
 *这个单例类在自身被加载时instance会被实例化，即便加载器是静态的。因此，对于资源密集，配置开销较大的单体更合理的做法是
 *将实例化(new)推迟到使用它的时候。即惰性加载(Lazy loading)，它常用于那些必须加载大量数据的单体。修改如类Singleton2.java
 */
public class Singleton1 {
	
	//私有的，静态类自身实例
	private static Singleton1 singleton=new Singleton1();
	
	//私有的构造方法,用private修饰后不能用new Singleton1()方法来创建对象
	/**
	 * 单例设计模式目标是保证一个类在内存中对象的唯一性。所以要保证自己的类中创建了对象之后，
	 * 其他的类不能再创建对象，只能获取这个对象。所以只要将本类中的构造函数私有化，其他程序就无法再创建该类对象。
	 */
	private  Singleton1(){
		
	}
	
	//公开，静态的工厂方法
	public static Singleton1 getInstance(){
		return singleton;
	}
	
	
	
}
