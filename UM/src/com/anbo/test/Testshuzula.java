package com.anbo.test;

public class Testshuzula {
  public static void main(String[] args) {
	  String a="与上期相同数：相同";
	  String special[]=a.trim().split("：");//拆分子策略 ：
	  
	  
	  String pt=special[0].trim();//选择项目
	  String ct=special[1].trim();//选择条件
	  int number=0;
	  if(special.length==3){
		  number=Integer.parseInt(special[2].trim());
	  }
	  
	  System.out.println("pt== "+pt);
	  System.out.println("ct== "+ct);
	  System.out.println("number== "+number);
}
}
