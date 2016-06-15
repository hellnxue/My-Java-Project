package com.java.Inner;
/**
 * 匿名内部类
 * 匿名内部类就是没有名字的内部类
 * 正因为没有名字，所以匿名内部类只能使用一次，它通常用来简化代码编写
 * 使用匿名内部类的前提条件：必须继承一个父类或实现一个接口
 *
 */
abstract class Person{
	public abstract void eat();
}
class Child extends Person{

	@Override
	public void eat() {
		System.out.println("继承了Persion的子类方法");
		
	}
	
}

/**
 * 接口的匿名内部类
 * 
 *
 */
interface Persons{
	public abstract void eats();
}

public class TestAnonymity {

	
	public static void main(String[] args) {
		
		/**
		 * 可以看到，我们用Child继承了Person类，然后实现了Child的一个实例，将其向上转型为Person类的引用

			但是，如果此处的Child类只使用一次，那么将其编写为独立的一个类岂不是很麻烦？

			这个时候就引入了匿名内部类
		 */
		Person p=new Child();
		p.eat();
		
		/**
		 * 可以看到，我们直接将抽象类Person中的方法在大括号中实现了

			这样便可以省略一个类的书写

			并且，匿名内部类还能用于接口上
		 */
		Person p1=new Person(){
			public void eat() {
				System.out.println("匿名内部类--继承了Persion的子类的方法");
				
			} 
		};
		p1.eat();
		/**
		 * 由下面的例子可以看出，只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现

			最常用的情况就是在多线程的实现上，因为要实现多线程必须继承Thread类或是继承Runnable接口
		 */
		Persons p2=new Persons(){
			@Override
			public void eats() {
				System.out.println("匿名内部类--接口    实现了Persion的方法");
				
			} 
		};
		p2.eats();
		
		/**
		 * Thread类的匿名内部类实现
		 */
		Thread t = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();
        
        /**
         * Runnable接口的匿名内部类实现
         */
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();

	}

}
