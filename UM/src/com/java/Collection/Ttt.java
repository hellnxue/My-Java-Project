package com.java.Collection;

import java.util.*;

public class Ttt {

	/**
	 * LinkedList是一个双向链表，它可以当做堆栈，队列或双端队列进行操作。
	 */
	public static void main(String[] args) {
		String s=new String();
		
		LinkedList<Integer> lt=new LinkedList<Integer>();
		lt.addAll(Arrays.asList(1,2,3));
		System.out.println(lt);
		lt.addFirst(111);
		System.out.println(lt);
		lt.addLast(333);
		System.out.println(lt);
		
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(0,1);
		ls.add(0,2);
		ls.add(0,3);
		System.out.println(ls.size());
		
		ls.remove(0);
		System.out.println("hehe= "+ls.get(0));
		
		
		for(int i=0;i<ls.size();i++){
			System.out.println("jkkk="+i);
			ls.remove(0);
			System.out.println("ttt="+ls.size());
		}
		
		System.out.println(ls);
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("hehe", "hehevalue");
		map.put("hehe", "yuyuyu");
		map.put(null, "dasdas");
		map.put("hihi1", null);
		map.put("hihi2", "hihi2");
		map.put("hihi3", "hihi2");
		System.out.println(map.get("hehe"));
		System.out.println(map.get(null));
		System.out.println(map.get("hihi1"));
		System.out.println(map.get("hihi2"));
		System.out.println(map.get("hihi3"));
	}

}
