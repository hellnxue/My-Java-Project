package com.java;

import java.util.*;
import java.util.Map.Entry;

public class TestArray {
	private static Integer bb;
	private static int aa;
   public static void main(String[] args) {
	int a[]={1,2,9,10,8};
	int b[]={4,2,8,2,6};
	
	System.out.println(aa);
	System.out.println(bb);
	Integer[] c=intercetion(a,b);
	for(int h:c){
		System.out.println("h= "+h);
	}
}
   public static Integer[] intercetion(int a[],int b[]){
	   Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
	   List<Integer> list=new ArrayList<Integer>();
	   for(int i=0;i<a.length;i++){
		   if(!map.containsKey(a[i])){
			   map.put(a[i], Boolean.FALSE);
			   
		   }
		   
	   }
	   System.out.println("map1~~~~= "+map);
	   
	   for(int i=0;i<b.length;i++){
		   if(map.containsKey(b[i])){
			   map.put(b[i], Boolean.TRUE);
		   }
		   
	   }
	   for(Entry<Integer,Boolean> e:map.entrySet()){
		   if(e.getValue().equals(Boolean.TRUE)){
			   list.add(e.getKey());
			   
		   }
		   
	   }
	   System.out.println("map2~~~~= "+map);
	   
	   Integer result[]={};
	   return list.toArray(result);
   }
}
