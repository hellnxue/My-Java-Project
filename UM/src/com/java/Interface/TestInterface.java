package com.java.Interface;
/**
 * 接口没有构造方法
 * 接口可以包含域（即类字段），但是这些域的隐式的是public static final的
 * 接口中的域自动是public的
 *接口的所有成员自动被设置为public的
 */
 interface Interface1{
	

	/**
	 * 域的修饰是static或final的,默认是public static final的
	 */
	static int i=0;
	final int f=1;
	
	public int x=0;
	
	int d=0;
	

	public  void f() ;
	
	 /**
     * 接口的方法声明修饰符默认是public abstract的，不能是其它修饰符
     */
	int c();
   
	//private void h();
	//protected  void bite();
	/**
	 * 接口中的方法不能是static的，因为接口中的方法没有方法体，并且要在具体类中实现.同理，抽象类中的抽象方法也是如此
	 */
	//public static void testStaticFunction();
	

}
/**
 * 接口可以继承接口
 * 
 *
 */
interface TestExtendsInterface extends Interface1{
	public int d=1;
	public  void f();
}


class Test6 implements Interface1{

	public int d=2;
	@Override
	public int c() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}
	
}


/**
 * 用反射查看接口中变量和方法的类型信息
 */
public class TestInterface {

	public static void main(String[] args) {
		/**
		 * 接口中static变量的用法
		 */
		int i=Interface1.d;
		System.out.println("接口中static变量："+i);
		
		//或者也可以向下面这样多态的使用，但引用调用的变量是接口的，不是实现类的。域中成员变量不具有多态性
		Interface1 ff=new Test6();
		System.out.println("域中的成员变量："+ff.d);
		
		Class c=null;
		try {
			c=Class.forName(Interface1.class.getName());
			System.out.println(c);
			System.out.println("是不是接口： "+c.isInterface());
			System.out.println("----------------查看变量类型------------------------- ");
			/**
			 * 用类型信息查看接口中任何成员变量的类型，都可以发现，全是public static final 修饰的，所以接口中的成员变量可以这么使用：Interface1.d
			 */
			System.out.println("查看接口属性变量x的类型等具体信息： "+c.getDeclaredField("x"));
			System.out.println("查看接口属性变量i的类型等具体信息： "+c.getDeclaredField("i"));
			System.out.println("查看接口属性变量f的类型等具体信息： "+c.getDeclaredField("f"));
			System.out.println("查看接口属性变量d的类型等具体信息： "+c.getDeclaredField("d"));
			
			System.out.println("----------------查看方法类型------------------------- ");
			
			System.out.println("查看接口方法的类型等具体信息： "+c.getDeclaredMethod("f", null));
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
