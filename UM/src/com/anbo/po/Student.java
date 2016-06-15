package com.anbo.po;

import java.util.*;
/**
 * 比较集合或数组，实现Comparable接口，重写compareTo方法
 * 
 *
 */
public class Student implements Comparable<Student> {
   private String id;
   private String name;
   private double score;
   private int age;
   private char sex;
   private Date birthday;
   public Student(String id,String name,double score,int age){
	   this.id=id;
	   this.name=name;
	   this.score=score;
	   this.age=age;
   }
   public Student(){}
   public static void hehe(){
	   System.out.println("heheheh");
	   
   }
   
public char getSex() {
	return sex;
}
public void setSex(char sex) {
	this.sex = sex;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}

public  String toString(){
	return this.id+"  "+this.name+" "+this.score+" "+this.age;
}
/**
 * 重写接口comparable接口的compareTo方法定义排序规则
 */
@Override
public int compareTo(Student o) {
	if (o instanceof Student) {//instanceof是判断对象o是不是Student类型  其返回true情况如下 1.o是Student类的对象 2.o是Student类子类的对象  返回false的情况下o是null
		System.out.println("true");
        Student s = (Student) o;
        if (this.getScore() >s.getScore() ) {
        	System.out.println(this.name);
            return 1; //由低到高
        } else if (s.getScore() == this.getScore()) {//如果成绩相同，则按照年龄由高到低
        	if ( this.getAge()> s.getAge()) {
                return -1; //由高到低
            } else if (s.getAge() == this.getAge()) {
            	return 0;
            } else {
                return 1;  
            }
        } else {
            return -1;  
        }
    } else {
    	System.out.println("false");
        throw new RuntimeException("不同对象之间无法比较");
    }
}
//重写compareTo()方法对对象数组排序
public static Student[] compareArrayForStudent(){
	Student stu[]={
			new Student("1","小新1",98,9),
			new Student("2","小新2",100,12),
			new Student("3","小新3",67,10),
			new Student("4","小新4",100,10),
		};
		
		Arrays.sort(stu);
		return stu;
}
//重写compareTo()方法对对象集合排序
public static List<Student> compareCollectionForStudent(){
	List<Student> lt=new ArrayList<Student>();
	lt.add(new Student("1","小新1",98,9));
	lt.add(new Student("2","小新2",100,12));
	lt.add(new Student("3","小新3",67,10));
	lt.add(new Student("4","小新4",100,10));
	
	Collections.sort(lt);
	return lt;
}
public static void main(String[] args) {
	System.out.println("对象数组排序------------------------------------------------");
	for(Student s:compareArrayForStudent()){
		System.out.println(s);
	}
	System.out.println("对象集合排序------------------------------------------------");
	for(Student s:compareCollectionForStudent()){
		System.out.println(s);
	}
}
   
}
