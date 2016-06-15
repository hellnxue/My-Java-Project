package com.java.Array;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * 求数组的交集、差集、并集(比较严谨的代码，也是比较麻烦的，看着有点晕)
 * 
 *
 */
public class ShuzuTest {

	/*可以用这个方法:System.arraycopy(src, srcPos, dest, destPos, length);
	src - 源数组。
	srcPos - 源数组中的起始位置。
	dest - 目标数组。
	destPos - 目标数据中的起始位置。
	length - 要复制的数组元素的数量。*/
	public static void main(String[] args) {    
        //测试union    
        String[] arr1 = {"abc", "df", "abc","hehe"};    
        String[] arr2 = {"abc", "cc", "df", "d", "abc"};    
        String[] result_union = union(arr1, arr2);    
        System.out.println("求并集的结果如下：");    
        for (String str : result_union) {    
            System.out.println(str);    
        }    
        System.out.println("---------------------可爱的分割线------------------------");    
   
        //测试insect    
        String[] result_insect = intersect( arr2,arr1);    
        System.out.println("求交集的结果如下：");    
        for (String str : result_insect) {    
            System.out.println(str);    
        }    
   
         System.out.println("---------------------疯狂的分割线------------------------");    
          //测试minus    
        String[] result_minus = minus(arr1, arr2);    
        System.out.println("求差集的结果如下：");    
        for (String str : result_minus) {    
            System.out.println(str);    
        } 
       List<Integer>  lt=new ArrayList<Integer>();
       lt.add(1);
       lt.add(2);
      System.out.println(lt.toString());
    }    
   
    //求两个字符串数组的并集，利用set的元素唯一性    
    public static String[] union(String[] arr1, String[] arr2) {    
        Set<String> set = new HashSet<String>();    
        for (String str : arr1) {    
            set.add(str);    
        }    
        for (String str : arr2) {    
            set.add(str);    
        }    
        String[] result = {};		 //指定一个String类型的数组   
        return set.toArray(result);  //返回String类型的数组  
    }    
   
    //求两个数组的交集    
    public static String[] intersect(String[] arr1, String[] arr2) {    
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        List<String> list = new ArrayList<String>();    
        for (String str : arr1) {  
        	//System.out.println("hehe   "+map.containsKey(str));
            if (!map.containsKey(str)) {    
                map.put(str, Boolean.FALSE); 
                System.out.println("1111111 "+map.keySet());
                System.out.println("map1 "+map);
            }    
        }    
        for (String str : arr2) {   
        	//System.out.println("heihei   "+map.containsKey(str));
            if (map.containsKey(str)) {    
                map.put(str, Boolean.TRUE); 
                System.out.println("222222"+map.keySet());
                System.out.println("map2 "+map);
            }    
        }    
        System.out.println("map.entrySet() "+map.entrySet());
        for (Entry<String, Boolean> e : map.entrySet()) { //Entry:映射项;  map.entrySet():返回映射的 collection 视图
        	System.out.println("entry  "+e.getKey());     //e.getKey();返回与map对应的键
        	System.out.println("e==  "+e);
            if (e.getValue().equals(Boolean.TRUE)) {      //e.getValue();返回映射的值
                list.add(e.getKey());    
            }    
        }    
   
        String[] result = {};    
        return list.toArray(result);//将list列表转存到一个新分配的数组并返回。 
    }    
   
    //求两个数组的差集    
    public static String[] minus(String[] arr1, String[] arr2) {    
        LinkedList<String> list = new LinkedList<String>();    
        LinkedList<String> history = new LinkedList<String>();    
        String[] longerArr = arr1;    
        String[] shorterArr = arr2;    
        //找出较长的数组来减较短的数组    
        if (arr1.length > arr2.length) {    
            longerArr = arr2;    
            shorterArr = arr1;    
        }    
        for (String str : longerArr) {    
            if (!list.contains(str)) { 
            	System.out.println("str1== "+str);
                list.add(str);    
            }    
        }    
        for (String str : shorterArr) {    
            if (list.contains(str)) {
            	System.out.println("str2== "+str);
                history.add(str);    
                list.remove(str);    
            } else {    
                if (!history.contains(str)) {  
                	System.out.println("str3== "+str);
                    list.add(str);    
                }    
            }    
        }    
   
        String[] result = {};    
        return list.toArray(result);    
    }     



}
