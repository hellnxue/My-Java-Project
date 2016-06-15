package com.java;

import java.util.*;

/**
 * java标识符的命名规则：字母，数字，下换线和“$”组成，并以字母、下换线或“$”开头
 * @author Administrator
 *
 */
public class TestJava {
   public static void main(String args[]){
	   
	   int _a=0;
	   //int 1b=1;
	   int $c=2;
	   //System.out.println(_a);
	   //System.out.println($c);
	  // System.out.println(getNum());
	   int number=1+2+4+7+11+16+22+29;
	   System.out.println(number);
	   
	   //getNum();
	   
	  List<Map<String,Object>> lt=new ArrayList<Map<String,Object>>();
	  Map<String,Object> map=new HashMap<String, Object>();
	  map.put("hh1", 123);
	  map.put("hh2", 1234);
	  //map.put("hh1", null);
	  lt.add(map);
	  
	  
	 System.out.println(map.get("hh1"));
	 
   }

   
   //算法
   public static int getNum(){
	   int number=1+2+4+7+11+16+22+29;
	   System.out.println(number);
	   int j=1;
	   int num=0;
	   
	   for(int i=1;i<=29;i++){
		   
		   num=num+(i+j);
		   j++;
		   System.out.println(num);
		   System.out.println("i    "+i);
		   System.out.println("j    "+j);
		   
	   }
	   return num;
   }
   public void hehe(){
	   
	   Integer aa[]={10};
	   aa[0]=1;
   }
 
}
