package com.java.Interface;
/**
 * 接口可以嵌套在类或其它接口中
 *
 */
class A{
	interface B{
		void f();
	}
	
	public class BImp implements B{

		public void f() {
			
		}
		
	}
	
	public interface C{
		void f();
	}
	public class CImp implements C{

		public void f() {
			
		}
		
	}
	
	/**
	 * private接口不能在定义它的类之外被实现
	 * @author liuxueping
	 *
	 */
	private interface D{
		void f();
	}
	private class DImp implements D{

		public void f() {
			
		}
		
	}
	
	public class DImp2 implements D{

		public void f() {
			
		}
		
		
	}
	
	public D getD(){return new DImp2();}
	
	private D dref;
	
	public void receiveD(D d){
		dref=d;
		dref.f();
	}
}

/*
 * 接口也可以嵌套接口
 * 接口的规则，So....接口类中的所有元素都是public的
 */
 interface E{
	 
	 /**
	  * 定义在接口中的接口（即嵌套接口）自动声明为public的
	  *
	  */
	 interface G{
			void f();
		}
	 public interface H{
			void f();
		}
	 //不能在接口中创建private接口
	// private interface B{}
	 
	 void g();
 }




public class NestingInterface {

	public class Bimp implements A.B{

		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	 class Cimp implements A.C{

		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
		
	}
	 /**
	  * 
	  * 实现嵌套接口E
	  * 注：在实现某个接口时，并不需要实现嵌套在其内部的其它接口
	  *
	  */
	 
	 class Cimp2 implements E{

		@Override
		public void g() {
			// TODO Auto-generated method stub
			
		}

			
			
		}
	 //嵌套接口中的私有接口不能被实现
	// class Dimp implements A.D{}
	
	 
	 
	public static void main(String[] args) {
		A a=new A();
		
		//A.D ad=a.getD();//getD()为new DImp2()，向上转型 private的接口不能向上转型
		
		//A.DImp2 d2=a.getD();
		
		//a.getD().f();
		
		A a2=new A();
		
		a2.receiveD(a.getD());
		a.receiveD(a.getD());
		
	}
	
	 class Eimp implements E{

		@Override
		public void g() {
			// TODO Auto-generated method stub
			
		}
	}
	 class EGimp implements E.G{

		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}

			
		}
}
