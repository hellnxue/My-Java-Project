package com.java;

import java.util.Random;
/**
 * 各种控制语句
 * @author liuxueping
 *
 */
public class TestControlStatement {
  public static void main(String[] args) {
   /**
    * while语句
    */
   //只要condition返回true,重复执行循环语句
	while(condition()){
		System.out.println("inside while");
		
	}
	 /**
	    *do  while语句
	    */
	//不管condition返回的是true或fasle，输出语句do都会执行一遍
	do{
		System.out.println("inside while");
	}while(condition());
	 /**
	    *for语句
	    */
	testFor();
	char r=90;
	System.out.println(r);
	/**
	    *foreach语句
	    */
	System.out.println("=====================foreach语句===================================");
	testForEach();
	System.out.println("=====================switch语句==================================="+(int)'a'+"是"+(char)97);
	System.out.println();
	testSwitch();
	System.out.println("=====================int类型和char类型转换==================================");
    int n=1;
    char n1=(char) (n+'0');
    System.out.println(n1);
    
    char ch = '9';
    int nn = (int)ch - (int)'0';
    System.out.println(nn);
}
  
  public static boolean condition(){
	  boolean result=Math.random()<0.99;
	  System.out.println(result+", ");
	  return result;
  }
  
  public static void testFor(){
	  for(char c=0;c<128;c++){
		  if(Character.isLowerCase(c)){
			  System.out.println("c "+(int)c+"   character:"+c);
		  }
		  
	  }
	  /**
	   * 逗号操作符，只存在for控制语句中的
	   */
	  for(int i=0,j=i+10;i<5;i++,j=i*2){
		  System.out.println("i= "+i+"   j= "+j);
		  
	  };
	  
  }
  
  public static void testForEach(){
	  for(char c:"I am glad to meet you".toCharArray()){
		  System.out.println("c "+c);
		  
	  }
	  
  }
  
  public static void testSwitch(){
	  
	  Random rand=new Random(47);
	  for(int i=0;i<20;i++){
		  int c=rand.nextInt(26)+'a';//加上偏移量'a'即可产生小写字母,a将自动转换为int值进行计算
		  System.out.println((char)c+"  "+"c ="+c);
		  switch(c){//c必须是int或char那样的整数值
			  case 'a':
			  case 'e':
			  case 'i':
			  case 'o':
			  case 'u':System.out.println("vowe1"); break;
			  case 'y':
			  case 'w':System.out.println("sss vowe1"); break;
		      default:System.out.println("constant"); 
		  }
		  
	  }
  }
}
