package com.java.Collection;

import java.util.*;

public class SetOfInteger {

	
	public static void main(String[] args) {

	   Random rd=new Random(47);
	   
	   /**
		 * Set不保存重复的元素
		 */
       Set<Integer> set=new HashSet<Integer>();
       for(int i=0;i<1000;i++){
    	   set.add(rd.nextInt(30));//rd.nextInt(30)返回从0到30之间的任意数字
    	   
       }
       System.out.println(set);
       
       System.out.println("hhhhhhhhh");
       
       /**
        * 排序的set
        * SortedSet进一步提供关于元素的总体排序 的 Set。这些元素使用其自然顺序进行排序，或者根据通常在创建有序 set 时提供的 Comparator 进行排序。
        */
       SortedSet<Integer> set1=new TreeSet<Integer>();
       for(int i=0;i<1000;i++){
    	   set1.add(rd.nextInt(30));
    	   
       }
       System.out.println(set1);
	}

}
