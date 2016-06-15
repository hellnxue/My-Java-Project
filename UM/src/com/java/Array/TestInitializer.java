package com.java.Array;
/**
 * 数组初始化
 *
 */
public class TestInitializer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 静态初始化方法一
		 */
		 int[] s=new int[]{1,2,4};
		 /*
		 * 静态初始化方法二
		 */
		 int[] s1={1,2,4};
		 
		/*
		 * 动态初始化	 
		 */
		 int[] i=new int[3];
		 //下面代码会报错：数组常量只能用于初始化。原因数组变量不识别{1,2,3}，{1,2,3}的常量数据只能用在数组初始化的时候使用
		// i={1,2,3};  
		 i[0]=1;
		 i[1]=1;
		 i[2]=3;
		 
		
		 
		 
		 i=s;
		 i[0]=1;
		 i[1]=2;
		 i[2]=3;
		 
		 int[] j={1,2,3};

	}

}
