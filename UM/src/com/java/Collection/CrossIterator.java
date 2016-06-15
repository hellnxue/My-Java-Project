package com.java.Collection;

import java.util.*;
/**
 * 迭代器：
 *   遍历并选择序列中的对象，不必关心序列的底层结构。
 *   迭代器统一了对容器的访问方式。
 * 
 *  ListIterator：
 *  允许程序员按任一方向遍历列表、迭代期间修改列表，并获得迭代器在列表中的当前位置。
 */
public class CrossIterator {

	public static void display(Iterator<Student> it){
		while(it.hasNext()){
			Student stu=it.next();
			System.out.println(stu);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("hehe");
		ArrayList<Student> l1=new ArrayList<Student>();
		l1.add(new Student());
		l1.add(new Student());
		
		LinkedList<Student> l2=new LinkedList<Student>();
		l2.add(new Student());
		l2.add(new Student());

		
		/**
		 * 迭代器是统一访问容器的一种方法
		 */
		display(l1.iterator());
		display(l2.iterator());
		
		
		/**
		 * ListIterator 可向前或向后遍历列表元素
		 */
		
		ListIterator<Student> li=l1.listIterator();
		
		/**
		 * 从前向后遍历列表元素
		 */
		while(li.hasNext()){
			System.out.println(li.next()+"   "+li.previousIndex()+"   "+li.nextIndex());
			
		}
		/**
		 * 从后向前遍历列表元素
		 */
		while(li.hasPrevious()){
			System.out.println("previous");
			System.out.println(li.previous());
			System.out.println(li.previousIndex()+"   "+li.nextIndex());//????????????从后向前的索引不懂
			
		}
		System.out.println("li1替换之前="+l1);
		
		/**
		 * 指定替换的位置替换集合中的元素
		 */
		while(li.hasNext()){
			li.next();
			if(li.nextIndex()==1){//替换集合中的第一个元素
				li.set(new Student());
			}
			
			
		}
		System.out.println("li2替换结果="+l1);
		
	}

}
