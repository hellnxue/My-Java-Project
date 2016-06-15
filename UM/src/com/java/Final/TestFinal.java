package com.java.Final;

import java.util.Random;
/**
 * final数据
 * 按照惯例，既是static又是final的域（即编译器常量）将用大写标示，并用下划线分隔个单词
 * 对于基本数据类型，final使数值恒定不变；而对于对象引用，final使引用恒定不变。一旦引用被初始化指向一个对象，就无法再把它指向另一个对象
 * 然而，对象自身的内容是可以修改的
 */
class  Value{

	 int i;
	
	public Value(int i){
		this.i=i;
	}

}
public class TestFinal{
	private static Random rand=new Random(47);
	private String id;
	public TestFinal(String id){
		this.id=id;
	}
	private final int valueOne=9;
	private static final int VALUE_TWO=99;
	
	public static final int VALUE_THREE=39;//VALUE_THREE是一个恒定初始值（即编译常量）
	
	private  final int i4=rand.nextInt(20);//非静态数值
	static final int INT_5=rand.nextInt(20);//静态数值，类装载时已被初始化，且只初始化一次，并不是每次创建新对象时都初始化
	
	private Value v1=new Value(11);
	private final Value v2=new Value(22);
	private static final Value VAL_3=new Value(33);
	
	private final int[] a={1,2,3,4,5,6};
	
	public String toString(){
		return id+": "+"i4="+i4+"  INT_5 "+INT_5+" v1="+v1+" v2="+v2+" VAL_3="+VAL_3;
	}
	
	
	
	public static void main(String[] args) {
		TestFinal tf=new TestFinal("fd1");
		tf.v2.i++;//v2的值可以改变
		tf.VAL_3.i++;
		tf.v1=new Value(9);
		for(int i=0;i<tf.a.length;i++){
			tf.a[i]++;
			
		}
		//tf.v2=new Value(0);//v2的引用不可以再指向其他对象
		//tf.VAL_3=new Value(3);
		//tf.a=new int[3];//数组的引用a不可以再指向其他对象
		System.out.println(tf);
		TestFinal tf2=new TestFinal("fd2");
		System.out.println(tf);
		System.out.println(tf2);
		
		final int x=rand.nextInt(10);
		int y=rand.nextInt(10);
		
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
}
