package com.java.Collection;

import java.util.*;
/**
 * java.util包中的Collections和Arrays有很多使用方法，，
 * Arrays.asList()方法接受一个数组或是一个用逗号分隔的元素列表(使用可变参数)，并将其转换为一个List对象
 * @author liuxueping
 *
 */

public class AddingGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] mi={6,7,8,9,10};
		
		boolean flag=collection.addAll(Arrays.asList(mi));
		System.out.println("flag= "+flag+"   "+collection);
		
		Collections.addAll(collection, 11,12,13,14,15); //将指定元素列表11,12,13,14,15添加到collection当中
		Collections.addAll(collection, mi);             
		
		List<Integer> ls=Arrays.asList(16,17,18,19,20);
		
		ls.set(1, 99);
		
		/**
		 * Arrays底层表示的是数组，因此不能调整尺寸，若是调整会引发异常UnsupportedOperationException（不支持请求的操作）
		 */
		//ls.add(21);
		
		

	}

}
