package com.anbo.test;

import java.util.Arrays;

public class TestSort {
  public static void main(String args[]){
	   int a[]={5,4,2,4,9,1};
	   /*Arrays.sort(a);//排序方法
	   for(int i:a){
		   System.out.println(i);
		   
	   }*/
	   int b[]={4,3,6,7,1,2};
	   int c[]=bubbleSort(b);
	   for(int j:c){
		   System.out.println("冒泡= "+j);
		   
	   }
	 //取出数组相同的部分
	   int d[]=getSame(a,b);
	   for(int x:d){
		   System.out.println(x);
		   
	   }
	   
   }
  //http://www.cnblogs.com/zxl-jay/archive/2011/09/24/2189711.html
 public static int[] bubbleSort(int[] args){//冒泡排序算法
	  System.out.println("hehe");
	  int temp;
     for(int i=0;i<args.length-1;i++){
    	 System.out.println("dhhdhddhhdh"+args[i]);
        for(int j=i+1;j<args.length;j++){
               if (args[i]>args[j]){
                         temp=args[i];
                        args[i]=args[j];
                        args[j]=temp;
               }
           }
        }
           return args;
      }


//取出数组中相同的部分
public static int[] getSame(int a1[],int b1[]){
	int c[]= new int[10];
	//int[] c = null;
	int z=0;
	for(int i=0;i<a1.length;i++){
//		System.out.println(a1[i]);
		for(int j=0;j<b1.length;j++){
			//System.out.println(b1[j]);
			if(a1[i]==b1[j]){
				c[z]=b1[j];
				z++;
			}
			
		}
		
	}
	return c;
}
}