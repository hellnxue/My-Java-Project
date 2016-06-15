package com.java.Interface;
/**
 *
 * 抽象类是普通的类与接口之间的一种中庸之道，所以对修饰符没有过分的限制，有构造方法
 * 抽象类创建对象不安全，所以不能创建对象（因为抽象类中可能有抽象方法，它没有实现体，不能调用，只能用继承去实现）
 * 抽象类的抽象方法的具体实现是由此类的继承者来实现的
 *
 * 抽象类可以实现接口
 * 抽象类不能实例化对象，允许有abstract修饰的方法
 */
 abstract  class TestAbstract1 implements He{

	private int i=1;
	int j=10;
	static int ss=8;
	
	TestAbstract1(){
		
		System.out.println("hehe");
	}
	
	public abstract void f();
	/**
	 * 抽象方法不能是static的，因为没有方法的具体实现，方法的具体实现要在子类中实现
	 */
	//public static abstract void g();
	
	abstract void yy();
	
	protected void h(){
		
	}
	public void c(){};
	public static void i(){}
	
	void s(){
		
	}
	/**
	 * private修饰的方法只能在自身类中使用，不能被子类继承
	 */
	private void k(){}
	
	/**
	 * 抽象类中可以有main方法
	 * @param args
	 */
   public static void main(String[] args) {
		System.out.println("hehe");
	}
}
 
interface He{
	public void hhs();
}

public  class TestAbstract extends TestAbstract1{
	
	
	@Override
	public void f() {
		System.out.println("implements TestAbstract1.f()");
		
	}
	public static void main(String[] args) {
		
		//TestAbstract1 tt=new TestAbstract1();//抽象类不能创建对象
		/**
		 * 用类型信息查看抽象类的具体信息
		 */
		
		Class c=null;
		
		try {
			c=Class.forName(TestAbstract1.class.getName());
			System.out.println(c);
			
			System.out.println("抽象类变量i的类型信息："+c.getDeclaredField("i"));
			System.out.println("抽象类变量j的类型信息："+c.getDeclaredField("j"));
			System.out.println("抽象类变量ss的类型信息："+c.getDeclaredField("ss"));
			
			/**
			 * 获得抽象类中方法的各种修饰类型信息
			 */
			System.out.println(c.getDeclaredMethod("f", null));
			System.out.println(c.getDeclaredMethod("h", null));
			System.out.println(c.getDeclaredMethod("c", null));
			System.out.println(c.getDeclaredMethod("i", null));
			System.out.println(c.getDeclaredMethod("s", null));
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void hhs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void yy() {
		// TODO Auto-generated method stub
		
	}
	void s(){}

}
