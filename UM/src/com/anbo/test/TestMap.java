package com.anbo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {
	 public static void main(String args[]){
		  List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		  Map<String,String> map=new HashMap<String,String>();
		  map.put("a1", "a1");
		  map.put("a2", "a2");
		  
		  System.out.println(map);
		  list.add(map);
		  System.out.println(list);
		  map.put("a1", "b1");
		  map.put("a2", "b2");
		  System.out.println(list);
		  System.out.println(map);
		  list.add(map);
		  System.out.println(list);
		  
	  }
}
