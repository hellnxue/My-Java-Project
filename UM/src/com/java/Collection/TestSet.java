package com.java.Collection;

import java.util.*;
import java.util.Map.Entry;

public class TestSet {
	public static void main(String args[]){
		int a[]={1,5,2,6};
		int b[]={2,3,1};
		Integer cc[]=union(a,b);
		System.out.println();
		for(int d:cc){
			
			System.out.println(d);//Set中的元素默认自己排序
		}
		testSet();
		
		hh();
	}
	//取出两个数组去重复后的所有元素,即并集
	public static Integer[] union(int a[],int b[]){
		Set<Integer> set=new HashSet<Integer>();
		for(int aa:a){
			set.add(aa);
		}
		for(int bb:b){
			set.add(bb);
			
		}
		Integer[] c={};
		return set.toArray(c);
	}
	/**
	 * Set里判断元素重复的根据是通过equals,判断两个对象的内容是否相同
	 */
	public static void testSet(){
		Set<String> set=new HashSet<String>();
		String s1=new String("hello");
		String s2=new String("hello");
		System.out.println("s1.equals(s2)= "+s1.equals(s2));
		System.out.println("set.add(s1)= "+set.add(s1));
		System.out.println("set.add(s2)= "+set.add(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		Set<String> set1=new HashSet<String>();
		set1.add(new String("c"));
		set1.add(new String("b"));
		set1.add(new String("a"));
		
		System.out.println("set1==="+set1);
		
		Set<String> set2=new HashSet<String>();
		set2.add("c");
		set2.add("b");
		set2.add("a");
		
		System.out.println("set2==="+set2);
	}
	
	public static void  hh(){
		int a[]={2,6,1,5,4};
		int b[]={10,3,6,5,8};
		
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		List<Integer> lt=new ArrayList<Integer>();
		for(int a1:a){
			map.put(a1, true);
		}
		for(int a2:b){
			if(map.containsKey(a2)){
				map.put(a2, false);
			}else{
				map.put(a2, true);
			}
				
			
		}
		for(Entry<Integer,Boolean> e:map.entrySet()){
			System.out.println("hehe "+e.getValue());
			if(e.getValue()==true){
				lt.add(e.getKey());
			}
				
			
		}
		
		System.out.println(map);
		Integer i[]={};
		System.out.println(lt);
	}

}
