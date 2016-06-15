package com.java.Array;

import java.util.*;
/**
 * 数组的初始化
 * 基本类型数组的初始化 function3
 * 对象类型数组的初始化function2，function1
 *
 *
 */
public class ArraysDefinitionObjectOrBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random rd=new Random(47);

		/**
		 * function No3
		 * 定义一个对象类型的数组，并初始化
		 */
		//定义一个指定大小的基本类型数组
		int[] a=new int[5];
		
		//初始化基本类型数组
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(10);
		}
		//输出基本类型数组的值
		for(int i:a){
			System.out.println(i);
		}
		
		System.out.println("----------------------------");
		/**
		 * function No1
		 * 定义一个对象类型的数组，并初始化
		 */
		String[] s={new String("hello"),"world"};
		for(String s1:s){
			System.out.println(s1);
		}
		/**
		 * function No2
		 * 定义一个对象类型的数组，并初始化
		 */
		String[] s1=new String[]{new String("hello"),"olaf"};
		for(String s11:s1){
			System.out.println(s11);
		}
		
		//对象的数组
		Olf o1=new Olf();
		o1.i=2;
		Olf[] o=new Olf[]{new Olf(),o1};
		
		for(Olf o11:o){
			System.out.println(o11.i);
		}
		
		/**
		 * 基本类型的数组，指定了大小并未初始化，如果是数值类型的则默认初始化为0
		 * 对象类型的数组，默认初始化为null
		 */
		int[] e=new int[2];
		System.out.println("基本类型之数值类型数组初始化： "+Arrays.toString(e));
		Integer[] f=new Integer[2];
		System.out.println("对象数组初始化： "+Arrays.toString(f));
		
		int[] d=null;
		System.out.println(Arrays.toString(d));
		
		//使用Arrays对数组排序
		String[] st=new String[]{"c","k","a","c"};
		Arrays.sort(st);
		for(String sr:st){
			System.out.println(sr);
		}
	}

}

class Olf{
	public int i=1;
	Olf(){
		System.out.println("hehe");
	}
}
