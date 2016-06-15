package com.java;
/**
 * 构造器初始化
 * 在类的内部，变量定义的顺序决定了初始化的顺序，即使变量定义散布于方法定义之间。
 * 创建一个对象的引用时，初始化对象的类成员会发生在构造函数之前
 * @author liuxueping
 *
 */
public class TestInitialization {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		House hh=new House();
		hh.f();
	}
	
	

}
class Window{
	Window(int marker){
		System.out.println("window="+marker);
	}
	
}
class House{
	Window w1=new Window(1);//第一个被初始化的
	House(){
		
		System.out.println("House()");
		 w3=new Window(33);
		
	}
	Window w2=new Window(2);//第2个被初始化的
	void f(){
		System.out.println("f()");
		
	}
	Window w3=new Window(3);//第3个被初始化的
	
}