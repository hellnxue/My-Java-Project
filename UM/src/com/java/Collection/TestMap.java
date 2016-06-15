package com.java.Collection;

import java.util.*;

class Person{
	private String name;
	Person(String name){
		this.name=name;
	}
}
class Pet{}
class P1 extends Pet{
	private String name;
	P1(String name){
		this.name=name;
	}
}
class P2 extends Pet{
	private String name;
	P2(String name){
		this.name=name;
	}
}
class P3 extends Pet{
	private String name;
	P3(String name){
		this.name=name;
	}
}

public class TestMap {

	
	public static void main(String[] args) {
		//Map<Person,List<? extends Pet>> map=new HashMap<Person,List<? extends Pet>>();  or.....
		Map<Person,List<Pet>> map=new HashMap<Person,List<Pet>>();
		map.put(new Person("helln1"), Arrays.asList(new P1("cat"),new P2("dog")));
		map.put(new Person("helln2"), Arrays.asList(new P2("mouse"),new P3("bird")));
		
		System.out.println("map.keySet()="+map.keySet());
		System.out.println("map.values()="+map.values());
		
		for(Person p:map.keySet()){
			System.out.println("p "+p+" has:");
			for(Pet pt:map.get(p)){
				System.out.println("pt "+pt);
			}
		}
		
		System.out.println(map.hashCode());
		P3 p=new P3("d");
		System.out.println(p.hashCode());
		
		/**
		 * m.keySet():返回此映射中包含的键的 Set 视图。
		 * m.values():返回此映射中包含的值的 Collection 视图。
		 * m.entrySet():返回此映射中包含的映射关系的 Set 视图。
		 */
		Map<Integer,String> m=new HashMap<Integer,String>();
		m.put(1, "hehe1");
		m.put(2, "hehe2");
		m.put(3, "hehe3");
		System.out.println(m.keySet());
		System.out.println(m.values());
		System.out.println(m.entrySet());
		
		
		/**
		 * 使用iterator遍历Map
		 */
		Iterator it=m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry  entry=(Map.Entry)it.next();
			Object key=entry.getKey();
			Object value=entry.getValue();
			
			System.out.println("key:"+key+"   value:"+value);
		}
		
		
		for(Map.Entry<Integer, String> e:m.entrySet()){
			String key1=e.getKey().toString();
			String value1=e.getValue().toString();
			System.out.println("key1:"+key1+"   value1:"+value1);
		}
		/**
		 * 遍历map中的键
		 */
		for(Iterator i=m.keySet().iterator();i.hasNext();){
			Object obj=i.next();
			System.out.println(m.get(obj));
			
		}
		/**
		 * 遍历map中的值
		 */
		for(Iterator i=m.values().iterator();i.hasNext();){
			Object obj=i.next();
			System.out.println(obj);
			
		}
	}

}
