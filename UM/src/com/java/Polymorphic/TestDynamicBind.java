package com.java.Polymorphic;

import java.util.*;

/**
 * 动态绑定:java中所有的方法都是通过动态绑定来实现多态机制的
 * 
 *
 */
class Shape{
	public void draw(){
		System.out.println("Shape.draw()");
	}
    public void erase(){
		
	}
}
class Circle extends Shape{
	public void draw(){
		System.out.println("Circle.draw()");
		
	}
    public void erase(){
		
	}
}
class Square extends Shape{
	public void draw(){
		System.out.println("Square.draw()");
	}
    public void erase(){
		
	}
}
class Triangle extends Shape{
	public void draw(){
		System.out.println("Triangle.draw()");
	}
    public void erase(){
		
	}
}

class RandomShapeGenerator{
	private Random r=new Random(47);
	public  Shape next(){
		switch(r.nextInt(3)){
			default:   //??????????
			case 0:return new Circle();
			case 1:return new Square();
			case 2:return new Triangle();
		
		}
	}
}
public class TestDynamicBind {
 
	private static RandomShapeGenerator rsg=new RandomShapeGenerator();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape[] s=new Shape[9];
		for(int i=0;i<s.length;i++){
			s[i]=rsg.next();
			
		}
		for(Shape sp:s){
			sp.draw();
			
		}
		

	}

}
