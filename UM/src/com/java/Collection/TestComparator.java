package com.java.Collection;

import java.util.*;

import com.anbo.po.Student;
/**
 * 比较集合或数组，实现Comparator接口，重写compare方法
 * 
 *
 */
public class TestComparator implements Comparator<Student>{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu[]={
				new Student("1","小新1",98,9),
				new Student("2","小新2",100,12),
				new Student("3","小新3",67,10),
				new Student("4","小新4",100,10),
			};
		Arrays.sort(stu, new TestComparator());
		for(Student s:stu){
			System.out.println(s);
		}
		
		System.out.println("q".compareTo("q"));

	}

	public int compare(Student o1, Student o2) {
			System.out.println("true");
	        if (o1.getScore() > o2.getScore()) {
	            return 1; //由高到低
	        } else if (o1.getScore() == o2.getScore()) {//如果成绩相同，则按照年龄由低到高排序
	        	if (o1.getAge() > o2.getAge()) {
	                return -1; //由低到高
	            } else if (o1.getAge() == o2.getAge()) {
	            	return 0;
	            } else {
	                return 1;  
	            }
	        } else {
	            return -1;  
	        }
	}

}
