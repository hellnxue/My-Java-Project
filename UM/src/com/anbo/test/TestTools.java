package com.anbo.test;
/**
 * 工具类
 * @author Administrator
 *
 */
public class TestTools {
   public static void main(String args[]){
	   
	   System.out.println("-------Math.ceil()向上取整，该值大于等于参数，并等于某个整数---");
	   System.out.println(Math.ceil(11.2));
	   System.out.println(Math.ceil(11.9));
	   System.out.println(Math.ceil(-11.2));
	   System.out.println(Math.ceil(-11.9));
	   
	   System.out.println("----Math.floor()向下取整，返回小于等于该参数的整数----");
	   System.out.println(Math.floor(11.2));
	   System.out.println(Math.floor(11.9));
	   System.out.println(Math.floor(-11.2));
	   System.out.println(Math.floor(-11.9));
	   
	   System.out.println("----Math.round(),它表示“四舍五入”，算法为Math.floor(x+0.5)，即将原来的数字加上0.5后再向下取整----");
	   System.out.println(Math.round(-8.9));
	   System.out.println(Math.round(-8.1));
	   System.out.println(Math.round(8.9));
	   System.out.println(Math.round(11.5));
	   System.out.println(Math.round(-11.5));
	   System.out.println(Math.round(-11.6));
	  
	   
   }
}
