package com.java;

import java.util.*;

public class TR {
	public static void main(String[] args) {
		/*List<List> type = new ArrayList<List>();
		List<Object> list=new ArrayList<Object>();
		
	    String 	status="标准 未投注,策略条件生成号码为空";
	    int  status1=3333;
	    
	    list.add(status);
	    list.add(status1);
	    type.add(list);
	    
	    System.out.println(type.toString());
	    for(int a=0;a<type.size();a++){
	    	System.out.println(type.get(a));
	    	for(int q=0;q<type.get(a).size();q++){
	    		System.out.println(type.get(a).get(q));
	    	}
	    }*/
		
	//3.
	    String aa=null;
	    
	    if(aa!=null&&!aa.equals("")){//null.equals()会报空指针异常
	    	System.out.println("ahahahah");
	    	
	    }
   //4.
	    ok:
	    	for(int i=0;i<10;i++) {
	    		
	    		System.out.println(i);
	    		if(5 == 5) System.out.println("ahahahah");
	    		break ok;
	    		
	    		}
  //6.
	    short i=1;
	  //  i=i+1;//i+1会自动提升表达式的类型，报强制类型转换错误
	    
	    i+=1;//+=是java中规定的运算符
	    
	    
  //7.
	    char h='1';
	    
  //10.
	    final StringBuffer t=new StringBuffer("Are you all right now?");
	    t.append("Yes,thanks mum");
	   System.out.println(t);
	   
  //11.
	   String t1="abc";
	   String t2="abc";
	   String t3=new String("abc");
	   String t4=new String("abc");
       System.out.println("t1==t2 "+(t1==t2));
       System.out.println("t1.equals(t2) "+(t1.equals(t2))); 
       System.out.println("t1==t3 "+(t1==t3)); 
       System.out.println("t3==t4 "+(t3==t4)); 
       System.out.println("t3.equals(t4) "+(t3.equals(t4))); 
       int a1=10;
       double a2=10;
       
       System.out.println(a1==a2); 
       //say();
	}
	
	public void say(){
		
		System.out.println("say hello to me");
		sayGoodBye();
	}
    public void sayGoodBye(){
		
		System.out.println("say goodbye to me");
	}
}
