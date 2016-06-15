package com.java;

public class $Af {
  public static void main(String args[]){
	 /* final String a="bdc";//被final修饰的变量，引用变量不能变，即a不能变，而引用变量所指对象的内容是可以改变的,例如sb；
	 // a="bc";
	 final StringBuffer sb=new StringBuffer("abc");
	 //sb=new StringBuffer("");
	  sb.append("abc");
	  System.out.println(sb);
	  System.out.println("==和equals()的区别");
	  String a1="hehe";
	  a1="hehe";
	  String a2="hehe";
	  System.out.println(a1==a2);
	  
	  System.out.println("-----------i++和++i在运算时的区别------------------");
	  int hehe=0;
	  hehe++;
	  System.out.println(hehe);//hehe++的值是0，而hehe本身增加1
	  int haha=0;
	  System.out.println(haha++);*/
	  
	  System.out.println("-----------++i先运算后赋值------------------");
	  int i=1;
	  int j=++i;
	  System.out.println(j);
	  System.out.println(i);
	  System.out.println("-----------i++先赋值后运算------------------");
	  int i1=1;
	  int j1=i1++;
	  System.out.println(j1);
	  System.out.println(i1);
	  int x=0;
	  x--;
	  System.out.println(x);
  }
}
