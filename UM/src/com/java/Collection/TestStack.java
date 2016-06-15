package com.java.Collection;

import java.util.*;
/**
 * 栈的使用
 * 后进先出的顺序
 *
 */
public class TestStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> sk=new Stack<String>();
		for(String s:"hello my word".split("")){
			
			String ss=sk.push(s);//把项压入堆栈顶部。
			System.out.println("ss="+ss);
			
		}
		
		while(!sk.empty()){
			
			System.out.println(" d ="+sk.pop()+"");//pop()移除堆栈顶部的对象，并作为此函数的值返回该对象。
		}

	}

}
