package com.anbo.test;

public class TestAnonymousInner {
	
	static Father fa=new Father(){
		
		public void test() {
			//super.test();
			System.out.println("22222222222");
		}
	};
	public static void main(String[] args) {
		fa.test();
	}
	public static abstract class Father{
		public void test(){
			System.out.println("1111111111111111111111");
		}
	}

}
