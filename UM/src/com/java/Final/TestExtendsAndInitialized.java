package com.java.Final;
/**
 * 类的继承与初始化
 * TestExtendsAndInitialized继承的类Insect是基类，加载TestExtendsAndInitialized的mian方法时，若有extends类会先加载基类，而static修饰的属性会最先初始化，不管是否创建了对象
 *
 */
 class Insect {
    
	private int i=9;
	protected int j;
	Insect(){
		System.out.println("i="+i+" j="+j);
		j=39;
	}
	
	private static int x1=printInit("static Insect.x1 initialized");
	
	static int printInit(String s){
		System.out.println(s);
		return 47;
	}
	
}
 
 public class TestExtendsAndInitialized  extends Insect{
	 
	 private int k=printInit("TestExtendsAndInitialized.k initialized");
	 public TestExtendsAndInitialized(){
		 System.out.println("k="+k);
		 System.out.println("j="+j);
	 }
	 private static int x2=printInit("TestExtendsAndInitialized.x2 initialized");
	 
	 public static void main(String[] args) {
		System.out.println("TestExtendsAndInitialized construcotr");
		TestExtendsAndInitialized ss=new TestExtendsAndInitialized();
	}
 }

