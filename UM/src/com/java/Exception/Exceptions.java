package com.java.Exception;
/**
 * 捕获处理各种异常
 * @author zhiyanguser
 *
 */
public class Exceptions {

	public static void main(String[] args) {

		try{

	         String strs=null;
	        // System.out.println(strs.toString());
	         
	         String a[]={};
	         System.out.println(a[0]);

		 }catch(NullPointerException e){
				
		        System.out.println("捕获到的空指针异常") ;
		        e.printStackTrace();
		
		 }catch(ArrayIndexOutOfBoundsException  e){
				
		        System.out.println("捕获到的数组下标越界异常") ;
		        e.printStackTrace();
		
		 }catch(Exception e){//捕获更细的异常要放在更粗的异常前面奥
		
		        System.out.println("捕获到的其它异常") ;
		        e.printStackTrace();
		
		 }finally{
			 System.out.println("不管怎样都要执行的部分。") ;
		 }

	}

}
