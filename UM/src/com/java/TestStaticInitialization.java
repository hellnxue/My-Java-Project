package com.java;
/**
 * 静态数据的初始化
 * @author liuxueping
 * static修饰的对象只初始化一次，一直是一个对象，只为对象分配一次存储空间
 */

class Bowl{
	Bowl(int marker){
		System.out.println("bowl="+marker);
		
	}
	public void f1(int marker){
		System.out.println("f1="+marker);
	}
	
}
class Table{
	static Bowl b1=new Bowl(1);
	Table(){
		System.out.println("Table()");
		b2.f1(1);
		
	}
	public void f2(int marker){
		System.out.println("f2="+marker);
	}
	static Bowl b2=new Bowl(2);
	
}
class Cupboard{
	Bowl b3=new Bowl(3);
	static Bowl b4=new Bowl(4);
	
	Cupboard(){
		System.out.println("Cupboard()"+Cupboard.class);
		System.out.println("被static修饰的bowl4(始终是同一个对象)="+b4);
		System.out.println("未被static修饰的Bowl4(始都不是同一个对象)="+b3);
		b4.f1(2);
	}
	public void f3(int marker){
		System.out.println("f3="+marker);
	}
	static Bowl b5=new Bowl(5);
}
public class TestStaticInitialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("new cupboard in main");
        new Cupboard();                             //bowl4和bowl5都不会再次输出，因为static只为它们分配一次内存
        System.out.println("new cupboard in main");
        new Cupboard();
        t.f2(1);
        c.f3(1);
        
	}
	static Table t =new Table();
	static Cupboard c =new Cupboard();
}
