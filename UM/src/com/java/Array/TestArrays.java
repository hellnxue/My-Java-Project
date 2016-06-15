package com.java.Array;

import java.util.*;
import java.util.Map.Entry;

/**
 * 数组操作工具
 * 数组拷贝
 * 数组比较
 * 数组排序
 * 数组冒泡排序
 * 求数组的交集、差集、并集（注：自己思考编写的，还纠正了以前方法的错误）
 * 数组排序算法：快速排序、冒泡排序、选择排序、插入排序
 * java.util.Arrays类
 * Arrays是一套用于操作数组的静态static实用方法
 *
 */
public class TestArrays {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		copyArrays();
		
		compareArrays();
		
		sortArrays();
		
	testMaopaoSort();
		
		/*testMins();
		testIntersect();
		
		testMinus();*/
		
		testSort();
		selectSort();
		insertSort();
		int i=2;
		String j="12";
		int x=Integer.parseInt(j);
		System.out.println(x);
		
		System.out.println("写着玩滴啦");
		
		
	}
	
	/**
	 * 基本类型数组、对象类型数组的拷贝和填充
	 * System.arraycopy (i, 0, j, 0, i.length)   i:源数组，表示从源数组的第0个位置开始复制   j:目标数组，表示从第0个位置开始复制i元素给j，i.length表示复制的长度
	 */
	public static void copyArrays(){
		int[] i=new int[7];
		int[] j=new int[10];
		
		//填充类型数组数组
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);
		
		System.out.println("i= "+Arrays.toString(i));
		System.out.println("j= "+Arrays.toString(j));
		
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j= "+Arrays.toString(j));
		
		Integer[] v=new Integer[5];
		Integer[] u=new Integer[10];
		
		//填充对象数组
		Arrays.fill(v, new Integer(47));
		Arrays.fill(u, new Integer(99));
		
		System.out.println("v= "+Arrays.toString(v));
		System.out.println("u= "+Arrays.toString(u));
		System.arraycopy(v, 0, u, 0, v.length);
		System.out.println("v= "+Arrays.toString(v));
		System.out.println("u= "+Arrays.toString(u));
	}
 
	/**
	 * 比较两个数组 Arrays.equals()
	 * 条件：元素个数必须相等，并且对应位置的元素也相等
	 * 数组相等是基于内容的，So...S1和S2比较结果是true
	 */
	public static void compareArrays(){
		int[] i=new int[10];
		int[] j=new int[10];
		Arrays.fill(i, 47);
		Arrays.fill(j, 47);
		System.out.println(Arrays.equals(i, j));
		
		i[1]=2;
		System.out.println(Arrays.equals(i, j));
		
		String[] s1=new String[4];
		Arrays.fill(s1, "hi");
		
		String[] s2=new String[]{new String("hi"),new String("hi"),new String("hi"),new String("hi"),};
		
		System.out.println("数组比较= "+Arrays.equals(s1, s2));
		
	}
	/**
	 * String排序依据词典排序顺序排序，大写字母排在最前，其次是小写字母
	 * 
	 * 若忽略大小写，可用String.CASE_INSENSITIVE_ORDER
	 */
	public static void sortArrays(){
		
		
		String[] s={"a","A","g","B"};
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		Arrays.sort(s,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(s));
	}
	
	
	/**
	 * 求交集
	 */
	public static void testMins(){
		int[] a=new int[]{2,5,4,3,10};
		int[] b={5,10,7,8,5};
		
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		List<Integer> lt=new ArrayList<Integer>();
		lt.toArray();
		
		for(int i:a){
			map.put(i, true);
			
		}
		System.out.println(map.entrySet());
		for(int j:b){
			//map.put(j, false);
			  if(map.containsKey(j)){
				  map.put(j, false);
			  }
		}
		
		for(Entry<Integer,Boolean> e:map.entrySet()){
			if(e.getValue().equals(Boolean.FALSE)){
				lt.add(e.getKey());
			}
		}
		
		//将list转成数组 (注意类型是包装类型，或对象类型的。不是基本类型)
		Integer[] c={};//指定一个目标类型数组
		c=lt.toArray(c);
		//或者用下面这种，重载的toArray()
		Object[] h=lt.toArray();
		
		System.out.println("转成的数组大小："+c.length);
		System.out.println("结果： "+map);
		System.out.println("交集结果： "+lt);
	}
	
	/**
	 * 求并集
	 * 最简单的，都放在map里就可以啦
	 */
	public static void testIntersect(){
		int[] a=new int[]{2,5,4,3,10};
		int[] b={5,10,7,8,5};
		
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		List<Integer> lt=new ArrayList<Integer>();
		
		for(int i:a){
			map.put(i, true);
			
		}
		System.out.println(map.entrySet());
		for(int j:b){
			map.put(j, false);
		}
		
        for(Entry<Integer,Boolean> e:map.entrySet()){
        	lt.add(e.getKey());
        }
		System.out.println("结果： ");
		System.out.println("并集结果： "+lt);
	}
	
	/**
	 * 求差集
	 * 将数组织放入map中相同的部分设置成一样的Boolean值，相反的Boolean值就是差集
	 */
	public static void testMinus(){
		int[] a=new int[]{5,2,4,3,10};
		int[] b={5,10,7,8,5};
		
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		List<Integer> lt=new ArrayList<Integer>();
		
		for(int i:a){
			map.put(i, true);
			
		}
		System.out.println(map.entrySet());
		for(int j:b){
			if(map.containsKey(j)){
				map.put(j, false);
			}else{
				map.put(j, true);
			}
		     
		}
		System.out.println("map:"+map);
        for(Entry<Integer,Boolean> e:map.entrySet()){
        	if(e.getValue().equals(Boolean.TRUE)){
        		lt.add(e.getKey());
        	}
        	
        }
		System.out.println("结果： "+map);
		System.out.println("差集结果： "+lt);
	}
	/**
	 * JAVA中在运用数组进行排序功能时，一般有四种方法：快速排序法、冒泡法、选择排序法、插入排序法。

		快速排序法主要是运用了Arrays中的一个方法Arrays.sort（）实现。

		冒泡法是运用遍历数组进行比较，通过不断的比较将最小值或者最大值一个一个的遍历出来。

		选择排序法是将数组的第一个数据作为最大或者最小的值，然后通过比较循环，输出有序的数组。
	
		插入排序是选择一个数组中的数据，通过不断的插入比较最后进行排序。
	 */
	/**
	 * 数组冒泡排序
	 */
	public static void testMaopaoSort(){
		System.out.println("冒泡排序");
		int[] a={10,4,3,6,3,22,5};
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				int temp;
				if(a[i]>a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	/**
	 * 数组快速排序,用Arrays.sort()方法，升序排序
	 */
	public static void testSort(){
		int[] a=new int[]{5,2,4,3,10};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	/**
	 * 数组选择排序
	 */
	public static void selectSort(){
		System.out.println("选择排序");
		int[] args=new int[]{5,2,4,3,10};
		for (int i=0;i<args.length-1 ;i++ ){
              int min=i;
              System.out.println("aaaaaaaaaaa");
              for (int j=i+1;j<args.length ;j++ ){
            	  System.out.println("hehehehe");
                     if (args[min]>args[j]){
                              min=j;
                              
                      }
              }
             if (min!=i){
                int temp=args[i];
                args[i]=args[min];
                args[min]=temp;        
             }
        }
		System.out.println(Arrays.toString(args));
	}
	/**
	 * 数组的插入排序
	 */
	public static void insertSort(){//插入排序算法
		System.out.println("插入排序算法");
		int[] args=new int[]{2,5,4,3,10};
        for(int i=1;i<args.length;i++){
        	System.out.println("args[i]= "+args[i]);
                for(int j=i;j>0;j--){
                	 System.out.println("args[j]= "+args[j]);
                	 System.out.println("args[j-1]="+args[j-1]);
                          if (args[j]<args[j-1]){
                                int temp=args[j-1];
                                  args[j-1]=args[j];
                                  args[j]=temp;        
                          }else break;
                          System.out.println("End-args[j]= "+args[j]);
                     	 System.out.println("End-args[j-1]="+args[j-1]);     
                  }
         }
        System.out.println(Arrays.toString(args));
 }
	
}
