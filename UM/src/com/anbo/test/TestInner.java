package com.anbo.test;
/**
 * 内部类：可以访问外部类的成员变量，不能定义静态成员，这是最大的特点
 * @author wm
 *
 */
public class TestInner {
	int out_i=1;
	
	  public class Inner1{//方法体外定义的内部类
		  // public static String a="";错误，内部类中不能定义静态成员
		  public  String a="";
		  public void method(){
			  System.out.println(out_i);
			  
		  }
	  }
	  public void method(int i){//方法体内定义的内部类
		  Inner1 inner=new Inner1();
		  inner.method();
		  final int j=1;//该变量前面必须有final修饰符,内部类要访问局部变量，局部变量必须定义成final类型
		  class Inner2{
			 
			   public void method(){
				   out_i=2;
				   System.out.println(j);
			   }
			  
		  }
		  Inner2 inner2=new Inner2();
	  }
	  public static void main(String args[]){
		 
		  TestInner t=new TestInner();
		  t.method(0);
		  
		  
	  }
	
}
