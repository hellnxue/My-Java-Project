package com.java.Modifier;
/**
 * java修饰符--private
 *
 */
public class TestPrivate1 {
	
	//私有的构造器
    private TestPrivate1(){
    	
    	
    }
    static TestPrivate1 returnModifier(){
    	
    	return new TestPrivate1();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestPrivate1 mf=new TestPrivate1(); //用private修饰的成员在自己类用可以访问

	}

}
