package com.anbo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.anbo.dao.StudentDao;
import com.anbo.dao.impl.StudentDaoImpl;
import com.anbo.po.Student;

public class TestList {
	
	public static void main(String args[]){
		//测试对象student中的static方法，可以不用student stu=new student(); stu.hehe()的最原始的方法就可以直接调用
		//Student.hehe();
		test();
		
	}
	
	public static void test(){
		//System.out.println("yunxing");
		StudentDao studao=new StudentDaoImpl();
		List<Student> list=studao.getAllStudent();
		
		//方法一，适用于String
//		Collections.sort(list, new Comparator<Student>() {
//            public int compare(Student arg0, Student arg1) {
//            	String st0=Double.toString(arg0.getScore());
//            	String st1=arg1.getScore()+"";
//                return st0.compareTo(st1);
//            }
//        });
		//方法2 适用于int double
		Collections.sort(list, new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				 if (o1.getScore() > o2.getScore()) {
			            return -1;
			        } else if (o1.getScore() == o2.getScore()) {
			            return 0;
			        } else {
			            return 1;
			        }
			}
			
		});
		
		for(Student stu:list){
			System.out.println(stu.getScore());
		}
		
	}
	
	/**
	 * static代码块，自动执行
	 */
	static{
		
		System.out.println(133);
		}
}
