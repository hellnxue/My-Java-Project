package com.java;
/**
 * 静态（static）方法中为什么不能用this关键字啊
 * 
 * 	静态方法中不能用this关键字，其解释是：因为this是个引用，哪个对象调用方法就引用哪个对象。 而静态方法有可能不是被对象调用的(有可能是直接用类名.方法名调用)，this无从引用。
 *
 *	类方法是属于类本身的 所有对象共享 this表示当前实例的引用 静态方法中不能引用非静态实例成员
 *
 *	静态的函数在类加载的时候就已经存在了。而此时内存中还没有对象。this指的就是当前对象。对象都没有，当然会报错了。
 *
 *	静态方法可以用类名来调用，那就没有对象之说了，而this指向的是调用该方法的对象本身
 *
 *	静态方法是属于整个类的，this指的是当前的对象
 */
class Ts{
	private static int h;
	public static int a;
	static{
		System.out.println("hahahahhaha");
		Ts.a=5;
	}
}
public class TestThisStaticVariable {

	 int i=1;
	 static int j=10;
	 
	static void get(){
		int i=2;
		System.out.println(i);
		
		//System.out.println(this.i);//不能在static方法中用this
		
		System.out.println(Ts.a);
		/**
		 * static变量前可以有private修饰，表示这个变量可以在类的静态代码块中，或者类的其他静态成员方法中使用（当然也可以在非静态成员方法中使用--废话），
		 * 但是不能在其他类中通过类名来直接引用，这一点很重要。实际上你需要搞明白，private是访问权限限定，static表示不要实例化就可以使用，这样就容易理解多了。
		 * static前面加上其它访问权限关键字的效果也以此类推
		 */
		//System.out.println(Ts.h);
	}
	public static void main(String[] args) {
		
		TestThisStaticVariable.get();
		
		TestThisStaticVariable th=new TestThisStaticVariable();
		th.get();
		
		/**
		 * 静态变量与实例变量区别
		 * static修饰的变量可以用没有实例化或已经实例化的引用去调用，通常不这么做，但这样做不会报错
		 * 实例变量在应用没有实例化的情况下调用此变量，会出现NullPointerException
		 */
		TestThisStaticVariable th2=null;
		System.out.println("静态j= "+th2.j);
		System.out.println("静态i= "+th2.i);

	}

}
