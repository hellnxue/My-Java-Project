package com.java.Collection;

import java.util.*;
/**
 * SortedSet:按对象的比较函数对元素排序
 * LinkedHashSet按照元素插入的次序
 *
 */
public class TestSortedSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		SortedSet<String> st=new TreeSet<String>();
		Collections.addAll(st, "one two three four five six seven eight nine".split(" "));
		System.out.println(st);
		System.out.println(st.first());
		System.out.println(st.last());
		Iterator<String> it=st.iterator();
		while(it.hasNext()){
			System.out.println("hehe= "+it.next());
		}
	}

}
