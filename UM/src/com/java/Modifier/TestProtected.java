package com.java.Modifier;

import com.java.TestForProtected;
/**
 * 使用final修饰方法的原因：1.把方法锁定，以防止任何继承类修改它的含义，2确保在继承中使方法行为保持不变，并且不会被覆盖
 * @author liuxueping
 *
 */
public class TestProtected extends TestForProtected{

	TestProtected(){
		System.out.println("TestProtected constructor");
	}
	
	public void tp(){
		bite();//从父类继承的方法
		modifyByFinal(); //用final修饰过的方法
	    modifyByPrivate();//用private修饰过的方法,该方法是调用的自身类的private方法，不是父类的
	}
	
	//被final修饰的方法不能被子类重写，编译器会报错
//	  public final void modifyByFinal(){
//		  System.out.println("这是一个用public修饰过的方法");
//	  }
	 private void modifyByPrivate(){
		  System.out.println("这是一个用private修饰过的TestProtected中的方法");
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestProtected tt=new TestProtected();
		tt.tp();
		
		
	}
	//覆盖了TestForProtected中的hehe()方法
	public void hehe(){
		  
	  }
}
