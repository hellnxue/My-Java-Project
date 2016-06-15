package com.java.Final;

import java.util.Random;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand=new Random(47);
		final int x=rand.nextInt(15);
		int y=rand.nextInt(15);
		
		System.out.println("x="+x);
		System.out.println("y="+y);
       
		int i=1;
		int s=i++;
		int j=1;
		int k=++j;
		int h=1;
		System.out.println(s);
		System.out.println(h+1);
		System.out.println(i);
		
		System.out.println("j="+j);
		System.out.println("k="+k);
		String a="";
	}

}
