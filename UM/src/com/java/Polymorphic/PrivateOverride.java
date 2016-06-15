package com.java.Polymorphic;
/**
 * 基类（即父类）的私有方法不能被子类覆盖
 * private方法会被认为是final的，不可覆盖
 * 只有非private方法才可以被覆盖。在到导出类中（即子类），对于基类中的private方法，最好采用不同的名字
 *
 */
public class PrivateOverride {

	private void f(){
		System.out.println("父类private修饰过的方法 f()");
	}
	
	public void e(){
		System.out.println("父类public修饰过的方法 e()");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateOverride tp=new TestPrivate();
		tp.f();//输出父类的私有方法
		tp.e();//输出子类覆盖了父类的方法
	}

}
class TestPrivate extends PrivateOverride{
	public void f(){
		System.out.println("子类public修饰过的方法 f()");
	} 
	public void e(){
		System.out.println("子类public修饰过的方法 e()");
	} 
}