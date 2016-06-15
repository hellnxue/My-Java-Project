package com.java.Modifier;

import com.java.TestForProtected;
/**
 * 
 * 被protected修饰符修饰的方法，除了不同包的继承了该类的类可以访问外，不能被不同包的其他类访问，与它同一个package的其他类可以访问
 *
 */
public class TestProtected1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestForProtected tfp=new TestForProtected();
		//tfp.bite();
		
	}

}
