package com.java.Polymorphic;
/**
 * 构造器内部多态方法的行为
 * 1.在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零。
   2.如前所述那样调用基类构造器，此时，调用被覆盖后的draw()方法(注意，要在调用RoundGlyph构造器之前调用)，由于步骤1 的缘故，我们此时会发现radius的值为0
   3.按照声明的顺序调用成员的初始化方法。
   4 调用导出类的构造器主体
 *
 *如果要调用构造器内部的一个动态绑定方法，就要用到那个方法的被覆盖后的定义。
 *
 *编写构造器的有效准则：用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其他方法。
 *（在构造器中唯一能够安全调用的那些方法是基类中的final方法（也适用于private方法，它们自动属于final方法），这些方法不能被子类覆盖。
 */
class Glyph{
	private int j=2; 
	
	void draw(){
		System.out.println("Glyph.draw()");
	}

	Glyph(){
		System.out.println("Glyph() before draw()"+this.j);
		draw();
		System.out.println("Glyph() after draw()");
		
	}
	
}
class RoundGlyhp extends Glyph{
	private int radius=1;
	void draw(){
		System.out.println("RoundGlyhp.draw().radius="+radius);
	}
	RoundGlyhp(int i){
		radius=i;
		System.out.println("RoundGlyhp.RoundGlyhp().radius="+radius);
	}
}
public class RoundGlyph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RoundGlyhp(5);

	}

}
