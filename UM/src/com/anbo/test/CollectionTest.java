package com.anbo.test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
	    //-------------------------交集分割线---------------------------------
		List<Integer> l1=new ArrayList<Integer>();
	    l1.add(1);
	    l1.add(5);
	    l1.add(3);
	    l1.add(8);
	    l1.add(8);
	    List<Integer> l2=new ArrayList<Integer>();
	    l2.add(3);
	    l2.add(10);
	    l2.add(5);
	    l2.add(2);
	    l2.add(8);
   	    //求出交集
		l1.retainAll(l2);
		System.out.println("交集大小：" + l1.size());
		for(int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}	
	    
		//-------------------------并集分割线---------------------------------
		List<Integer> l3=new ArrayList<Integer>();
	    l3.add(1);
	    l3.add(5);
	    l3.add(3);
	    l3.add(8);
	    
	    List<Integer> l4=new ArrayList<Integer>();
	    l4.add(3);
	    l4.add(10);
	    l4.add(5);
	    l4.add(2);
	    l4.add(8);
	    
	    l3.removeAll(l4);
	    l3.addAll(l4);
	    System.out.println("并集大小：" + l3.size());
		for(int i = 0; i < l3.size(); i++) {
			System.out.println(l3.get(i));
		}
		//-------------------------差集分割线---------------------------------
		List<Integer> l5=new ArrayList<Integer>();
	    l5.add(1);
	    l5.add(5);
	 
	    
	    List<Integer> l6=new ArrayList<Integer>();
	   
	    l6.add(10);
	    l6.add(5);
	    l6.add(2);
	   
	    
	   
	    l6.removeAll(l5);
	    
	    System.out.println("差集大小：" + l6.size());
		for(int i = 0; i < l6.size(); i++) {
			System.out.println(l6.get(i));
		}
		
	}
	
	
}
