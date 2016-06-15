package com.java.Final;

/**
 * 
 * final修饰的类不能被继承
 *
 */

class TF1{
	
}
final class TF2{
	final int i=7;
	int j=1;
	TF1 tf=new TF1();
	void f(){
		
	}
}

//class TF3 extends TF3{
//	
//	
//}

public class FinalClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TF2 tf=new TF2();
		tf.f();
		//tf.i=10;
		tf.j++;

	}

}