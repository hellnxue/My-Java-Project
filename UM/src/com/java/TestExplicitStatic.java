package com.java;
/**
 * 显示的静态初始化
 * @author liuxueping
 *
 */
public class TestExplicitStatic {

	public static void main(String[] args) {
		System.out.println("inside main()");
        Cups.cup1.f(99);
	}
	static Cups c=new Cups();
	static Cups cc=new Cups();

}
class Cup{
	Cup(int marker){
		System.out.println("Cup="+marker);
		
	}
	public void f(int f){
		System.out.println("f="+f);
	}
}
class Cups{
	static Cup cup1;
	static Cup cup2;
	
	/**
	 * 静态代码块部分
	 */
	static{
		cup1=new Cup(1);//无论是用Cups.cup1还是Cups c=new Cups()，cup1只初始化一次
		cup2=new Cup(2);
	}
	
	Cups(){
		System.out.println("Cups");
		
	}
	public void f(int f){
		System.out.println("f="+f);
	}
}