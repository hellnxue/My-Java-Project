package com.java.Exception;
/**
 * ����������쳣
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
				
		        System.out.println("���񵽵Ŀ�ָ���쳣") ;
		        e.printStackTrace();
		
		 }catch(ArrayIndexOutOfBoundsException  e){
				
		        System.out.println("���񵽵������±�Խ���쳣") ;
		        e.printStackTrace();
		
		 }catch(Exception e){//�����ϸ���쳣Ҫ���ڸ��ֵ��쳣ǰ���
		
		        System.out.println("���񵽵������쳣") ;
		        e.printStackTrace();
		
		 }finally{
			 System.out.println("����������Ҫִ�еĲ��֡�") ;
		 }

	}

}
