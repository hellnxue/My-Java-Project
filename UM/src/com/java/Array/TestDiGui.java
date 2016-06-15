package com.java.Array;
/**
 * µİ¹éÔËËã
 * 
 *
 */
public class TestDiGui {
	static int i=1;
	static int age=20;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		getAge();
	}
	
	public static void getAge(){
		
		i++;
		age+=3;
		System.out.println("i="+i+"  age="+age);
		if(i<8){
			getAge();
		}
	}

}
