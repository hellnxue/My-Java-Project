package com.java;

public class TestStatic {
	
	static int i=0;
	int j=0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStatic s=null;
		System.out.println(s.i);
		//System.out.println(s.j);
		
		String s1=" hellow world ";
		String s2=" hello";
		String s3="hello ";
		int i=10;
		System.out.println(s1.length()+"   "+s1.trim().length());//去左右空格
		System.out.println(s1.replaceAll("\\s*", ""));//去所有空格
		System.out.println(s1.replaceAll("^\\s*", ""));//去左空格
		System.out.println(s1.replaceAll("\\s*$", ""));//去右空格
	}

}
