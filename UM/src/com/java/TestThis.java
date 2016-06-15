package com.java;
/**
 * 关键字this
 * @author liuxueping
 *
 */
public class TestThis {
    int i=0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestThis tt=new TestThis();
		tt.increment().increment().increment().increment().print();//用一个对象执行多次操作
		
		//
		
		
	}
   
	 public void pick(){
		 
	 }
	public void pit(){
		//this.pick();
		pick();//在方法内部调用同一个类的其他方法不需要用this引用，直接调用即可。
	}
	
	public TestThis increment(){
		i++;
		return this;//返回对当前对象TestThis的调用
	}
	
	public void print(){
		System.out.println("i="+i);
	}
	
	Student s=new Student("s");
	
	
}
