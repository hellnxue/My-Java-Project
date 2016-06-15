package com.java.Collection;

import java.util.*;
/**
 * 迭代器
 * 1、Iterator将准备好返回序列的第一个元素
 * 1.使用next()获得下一个元素
 * 2.使用hasNext()检查序列中是否还有元素
 * 3.使用remove()将迭代器新近返回的元素删除
 *
 */
class Student{
	private int id=1;
}
public class SimpleIteration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Student> ls=new ArrayList<Student>();
		ls.add(new Student());
		ls.add(new Student());
		ls.add(new Student());
		
		
		//遍历
		Iterator<Student> it=ls.iterator();
		while(it.hasNext()){
			Student s=it.next();
			System.out.println(s);
		}
		
		it=ls.iterator();
		
		for(int i=0;i<1;i++){
			Student s=it.next();
			System.out.println("closer element  "+s);
			it.remove();
		}
		
		System.out.println(ls);
	}

}
