package com.anbo.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.anbo.util.MybatisFactory;

public class aa {
     
	public static void main(String[] args) {
		/*System.out.println(Singleton2.getInstance());
		System.out.println(Singleton2.getInstance());
		System.out.println(MybatisFactory.getSqlSession());
		System.out.println(MybatisFactory.getSqlSession());*/
		java.util.Date curDate = new java.util.Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(curDate);
		
		
		System.out.println(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		System.out.println(Calendar.getInstance().getTime().getTime());
		TestStatic t=new TestStatic();
		String[] arr1 = {"abc", "df", "abc"};    
	    String[] arr2 = {"abc", "cc", "df", "d", "abc"};   
	    
	    String x[]=new String[arr1.length>arr2.length?arr1.length:arr2.length];
	    List<String> l1=new ArrayList<String>();
	    List<String> l2=new ArrayList<String>();
	    for(int i=0;i<arr1.length;i++){
	    	l1.add(arr1[i]);
	    	
	    }
	    for(int i=0;i<arr2.length;i++){
	    	l2.add(arr2[i]);
	    	
	    }
	    l1.retainAll(l2);
	    String[] aa={};
	    String bb[]=l1.toArray(aa);
	    System.out.println("haha  "+bb.length);
	    for(int i=0;i<bb.length;i++){
	    	System.out.println("hehe "+bb[i]);
	    	
	    }
	    
	    
	    List<String> ls=new ArrayList<String>();
	    System.out.println("hahahah===  "+ls.size());
	    
	}
}

 class bb{
	public void ss(){
		
		System.out.println("hehe");
	}
}
 class cc{
		
 }
 class dd{
		
 }
