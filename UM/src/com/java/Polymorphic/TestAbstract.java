package com.java.Polymorphic;

public  class TestAbstract {
	

	public static void main(String[] args) {
		int i=TestAbstractClass.i;
		System.out.println("抽象类里的static属性: "+i);
		//TestAbstractClass s=new TestAbstractClass();
		TestAbstract h=new TestAbstract();
	}

}
class H{}
abstract class TestAbstractClass extends TestAbstract{
	public static  int i=1;
	private int j=0;
	
	public abstract void h();
}
