package com.java.Polymorphic;
/**
 * 组合、继承和多态在构造顺序上的调用
 * 构造器和多态 ：  基类的构造器总是在到导出类的构造过程中被调用
 * 初始化顺序：1)调用基类（即父类）构造器，这个步骤会不断的反复递归下去。
 * 2)按声明顺序调用成员的初始化方法
 * 3)调用导出类构造器的主体
 * 
 *
 */
class Meal{
	int i=1;
	Meal(){
		System.out.println("Meal()"+this.i);
	}
}
class Bread{
	Bread(){
		System.out.println("Bread()");
	}
}
class Cheese{
	Cheese(){
		System.out.println("Cheese()");
	}
}
class Lettuce{
	Lettuce(){
		System.out.println("Lettuce()");
	}
}
class Lunch extends Meal{
	Lunch(){
		System.out.println("Lunch()");
	}
}
class PorTableLunch extends Lunch{
	PorTableLunch(){
		System.out.println("PorTableLunch()");
	}
}
/**
 * 若无继承，类成员会按照定义顺序进行初始化（先是类成员再是构造器）
 */
//public class ConstrucotrPolymorphic {
//	private Bread b=new Bread();
//	private Cheese c=new Cheese();
//	private Lettuce l=new Lettuce();
//	ConstrucotrPolymorphic(){
//		System.out.println("ConstrucotrPolymorphic()");
//	}
//	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		
//		ConstrucotrPolymorphic cp=new ConstrucotrPolymorphic();
//		
//
//	}
//
//}
public class ConstrucotrPolymorphic extends PorTableLunch{
	private Bread b=new Bread();
	private Cheese c=new Cheese();
	private Lettuce l=new Lettuce();
	ConstrucotrPolymorphic(){
		System.out.println("ConstrucotrPolymorphic()");
	}
	public static void main(String[] args) {
		
		new ConstrucotrPolymorphic();
		

	}

}
