package com.anbo.test;
/**
 * 不同点与相同点
相同点：结果一样，实现相同的功能
不同点：运行时走的程序不同
& 逻辑与
| 逻辑或
&& 短路与：只要有一个为false，比较结果就为false
|| 短路或:只要有一个为true，比较结果就为true
 * @author wm
 *
 */
public class TestYuHuo {
   public static void main(String args[]){
	      int a=1,b=2;
		  boolean flag1=(a>3)&&(a+b)<5;
		  boolean flag11=(a>3)&(a+b)<5;
		  
		  System.out.println(flag1);//a>3结果为false，所以对(a+b)>5不在做判断，就像短路。不同：如果是&符号，不管前面是true还是false，&后的表达式都会判断出结果
		  System.out.println(flag11);
		  boolean flag2=(a>2)||(a+b)<6;//a>2为false,继续对(a+b)<6进行判断。如果a>2的结果为true,后面的(a+b)<6不在进行判断。
		  boolean flag22=(a<2)|(a+b)<6;
		  System.out.println("flag2==== "+flag2);
		  System.out.println(flag22);
		  
		  System.out.println("==========================");
		  System.out.println(true&false);
		  
		  System.out.println(true&&false);
		  
		  System.out.println(false|true);
		  System.out.println(true||false);
		  String s=null;
		  if(s==null||!s.equals("")){//若换做s!=null||!s.equals("")的话，回报异常，因为对!s.equals("")进行了判断
			  System.out.println("hehe");
			  
		  }
		  
	   
   }
}
