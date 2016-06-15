package com.java;
/**
 * 非静态初始化
 * @author liuxueping
 *
 */
public class TestNotStaticObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        new Cupps(1);
        new Cupps(2);
	}
	

}
class Cupp{
	Cupp(int marker){
		System.out.println("Cupp="+marker);
		
	}
	public void f(int f){
		System.out.println("f="+f);
	}
}
class Cupps{
	 Cupp cupp1;
	 Cupp cupp2;
	
	/**
	 * 支持匿名内部类初始化
	 */
	{
		cupp1=new Cupp(1);//在构造器之前初始化
		cupp2=new Cupp(2);
	}
	
	Cupps(){
		System.out.println("Cupps");
		
	}
	Cupps(int i){
		System.out.println("Cupps="+i);
		
	}
	public void f(int f){
		System.out.println("f="+f);
	}
}