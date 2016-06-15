package com.java.Generosity;

class Test1{}
class Test2{}
public class Holder<T> {
	private T a;
	
	public Holder(T a){
		this.a=a;
	}
	
	public void set(T a){
		this.a=a;
	}
	public T get(){
		return a;
	}

	
	public static void main(String[] args) {
		Holder<Test1> h1=new Holder<Test1>(new Test1());
		h1.set(new Test1());
		System.out.println(h1.get());
		
		Holder<Test2> h2=new Holder<Test2>(new Test2());
		System.out.println(h2.get());
	}

}
