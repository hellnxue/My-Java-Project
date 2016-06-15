package com.java.Inner;

public class TestInner {

	private int i=0;
	private int c=3;
	public int j=1;
	private static int a=1;
	private static int v_s=100;
	TestInner(){
		
		this.i=1;
	}
	public void h(){
		int i=0;
		System.out.println(this.i);
		System.out.println(i);
	}
	/**
	 * 1、方法外的内部类
	 * 内部类在没有同名成员变量和局部变量的情况下，内部类会直接访问外部类的成员变量，而无需指定Out.this.属性名

	否则，内部类中的局部变量会覆盖外部类的成员变量

	而访问内部类本身的成员变量可用this.属性名，访问外部类的成员变量需要使用Out.this.属性名
	 * 非静态内部类不能有静态数据、静态方法
	 *
	 */
	class In1{
		private int i=11;
		static final int hh=0;//？？？ 内部变量不能用static修饰，但这里.....？？？？？
		//static int jk=10;
		public void print(){
			 int i=12;
			System.out.println("局部变量i="+i);
			System.out.println("内部类变量i="+this.i);
			System.out.println("外部类变量i="+TestInner.this.i);//内部类方法访问外部类成员的方式
			System.out.println("外部类变量j="+j);
			System.out.println("外部类变量j="+v_s);
		}
		/**
		 * 非静态内部类不能定义静态成员和方法
		 */
		//public static void pp(){}
	}
	
	/**
	 * 2、
	 * 静态内部类（方法外部）
	 * 用static 将内部内静态化，那么内部类就只能访问外部类的静态成员变量，具有局限性
	 *
	 */
	static class In2{
		private int i=11;
		public static int hhj=0;
		public void print(){
			 int i=12;
			System.out.println("静态内部类变量a="+a);
			System.out.println("静态内部类变量i="+i);
			//System.out.println("内部类变量j="+j);
		}
		public static void Hee(){}
	}
	/**
	 * 3、
	 * 静态内部类（静态方法内部）
	 * 在静态方法内部定义的类也是静态内部类。
	 * 与在方法中的内部类一样，要往外部类方法的内部类传入参数，该参数必须定义成final的   
	 * 要访问全局变量，全局变量必须定义成static的
	 *若要访问外部方法的局部变量，局部变量必须定义成final的
	 */
	public static void staticFunction(){
		final int io=90; 
		class In22{
			private int j=90;
			public void print(){
				System.out.println("静态方法内部类变量io="+io);
				System.out.println("全局变量v_s="+v_s);
				System.out.println("内部类变量j="+j);
			}
		}
	}
	public void innerClass(){
		//静态内部类的调用
		new TestInner.In2().print();
		//调用静态方法
		TestInner.staticFunction();
		
		//非静态内部类的调用
		new TestInner.In1().print();
		new TestInner().new In1().print();
	}
	
	/**
	 * 4、
	 * 私有内部类
	 * 如果一个内部类只希望被外部类中的方法操作，那么可以使用private声明内部类
	 */
	private class In3{
		public void print(){
			System.out.println("私有内部类变量i="+i);
		}
	}
	
	//外部类方法
	public void outPrint(){
		 new In3().print();
	}
	
	public void outPp(){
		System.out.println("outPp()");
		new In2().print();
		new TestInner.In2().print();
		int i=new TestInner.In1().i;
	}
	
	/**5、局部内部类
	 * 外部类方法内定义的内部类，也称之为局部内部类
	 * 在下面的代码中，我们将内部类移到了外部类的方法中，然后在外部类的方法中再生成一个内部类对象去调用内部类方法

		如果此时我们需要往外部类方法中的内部类中传入参数，那么外部类的方法形参必须使用final定义

		至于final在这里并没有特殊含义，只是一种表示形式而已
	 * @param h
	 */
	public void Print(final int h){
		final int uu=13;
		 class In4{
			private int in=4;
			public void in4Print(){
				System.out.println("方法内部类的传入参数="+h);
				System.out.println("方法内部类的变量in="+in);
				System.out.println("方法的局部变量uu="+uu);
				System.out.println("外部类成员变量i="+i);
			}
		}
		//调用方法内部类的方法
		 new In4().in4Print();
		 
		 In4 in4=new In4();
	}
	
	
	
	
	public static void main(String[] args) {
		TestInner.In1 in1=new TestInner().new In1();//创建内部类的方式
		in1.print();
		new TestInner().h();
		
		System.out.println("内部类的成员变量    ==="+in1.i);
		
		/**
		 * 因为内部类被静态化，因此TestInner.In2可以当做一个整体看，可以直接new 出内部类的对象（通过类名访问static，生不生成外部类对象都没关系）
		 */
		
		TestInner.In2 in2=new TestInner.In2();
		
		in2.print();
		
		/**
		 * 下面的代码中，我们必须在Out类里面生成In类的对象进行操作，而无法再使用Out.In in = new Out().new In() 生成内部类的对象

			也就是说，此时的内部类只有外部类可控制

			如同是，我的心脏只能由我的身体控制，其他人无法直接访问它
		 */
		//TestInner.In3 in3=new TestIner().new In3();
		
		TestInner  out=new TestInner();
		out.outPrint();
		out.outPp();
		
		
		TestInner t=new TestInner();
		t.Print(123);
		
	}

}
