package com.anbo.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
   public static void main(String args[]){
	   System.out.println("hello world!");
	   String a="15";
	   String b="123";
	   String aa=b.substring(b.length()-1);
	  System.out.println(aa);
	  
	  int z=123;
	  String x=z+"";
	  System.out.println(x.length());
	  System.out.println(x.substring(x.length()-1));
	  
	  //将int类型转换成string
	  int i =8;
      String s =Integer.toString(i);
      String g =String.valueOf(i);
      String f=i+"";
      System.out.println(g.substring(g.length()-1));
      
      List ee = new ArrayList();
      ee.add("1");
      ee.add("2");
      System.out.println("= "+ee.size());
      
      //ee.re;
      System.out.println(ee.size());
     // sayHello();
     //ll();
      //le();
      //sayHellos();
      getSerialCombination();
   }
   
   //求质数
   public static void sayHello(){
	   
	   System.out.println("hello kitty");
	   
	   //判断出质数
	   int a[]={2,9,4,5,7};
	   
	   int temp=0;//质数个数
	   
	   for(int j=0;j<a.length;j++){
		   
		   int n=97;       //n 可以是任何数，以29为例子 

		   int sum;      //计算存放的变量 

		   int t=0;       //累计变量t，用于计算整除次数的累计变量，用于判断质数和合数的过度变量

		   /*

		   1、 判断概念：质数只能被1和本身整除。

		   那么可以用 i=n-1 作为循环条件，将任意数 n 减 1，从1到n 范围的数，全部除一遍，就知道是不是质数。

		    

		   2、下面算法是，将29分别与 1—28的数相除，同时用上%算法，求余数值。若余数=0就是整除，那么t 增加1，t若是大于1次，证明在 1到（n-1）这个过程相除存在第三个能被整除的，证明不是质数。 ）

		   */ 

		   for(int i=n-1;i>=1;i--) {    //  i 是规划 和n值相除的范围数 就是 1—28的范围，                   

		                                // 假如 n=33，那么这里就是1—32范围

		   sum=n%i;            //求余数值

		   if(sum==0)       //若余数=0的，话，执行 t 累加 

		   t++;           //  条件满足，循环累加  （任何数除于1，都成立，所以t必须至少=1的。）

		    }
		   if (t>1){     //若t 累加 超过了1，证明不是质数，这是判断质数 合数的方法
			   
		    System.out.println("   n的值为"+n+"   n是合数");     
		    	
		    } else{         

		   /* t >1不成立的话，只有1次，就是质数，有人问，若是0呢？——这个问题问得好，告诉你不可能有0。*/ 
		    	if(n!=1){
		    		temp++;
		 		   System.out.println("   n的值为"+n+"   n是质数");
		    	}
		    	 }
		   
	   }
	   System.out.println("质数个数为 "+temp);

   }
   public static int getSerialCombination() {
		int temp=0;
		int lg = ll();//连号个数
		int lz=le();//连号组数
		if(lg!=0&&lz!=0){
			//System.out.println("hehe");
			if((lg==2&&lz==1)||(lg==3&&lz==2)){
				temp=3;
			}else if(lg==3){
				temp=4;
			}else if(lg==4){
				temp=5;
			}else if((lg==2&&lz==2)||(lg==1&&lz==1)){
				temp=2;
			}
		}else if(lg==0&&lz==0){
			System.out.println("hehe");
		    temp=0;	
		}
		
		System.out.println("连号组合=== "+temp);
		return temp;
	}
   //连号个数
   public  static int ll(){
	   System.out.println("ahahah"+Integer.parseInt("01"));
	   int a[]={1,2,4,5,7};
	   
	   int temp=0;
	   
	   for(int i=0;i<a.length-1;i++){
		   System.out.println("a[i]=== "+a[i]);
			   if(a[i]+1==a[i+1]){
				   temp++;
				   System.out.println("a[j]=== "+a[i+1]);
			   }
	   }
	   System.out.println("连号个数 ="+temp);
	   return temp;
   }
   
   //连号组数
   public static int le(){
      String bn[]={"02","01","03","06","05"};
	   
	   Arrays.sort(bn);
	   for(int t=0;t<bn.length;t++){
		   System.out.println("bn = "+bn[t]);
		   
	   }
	   
	   System.out.println("ahahah"+Integer.parseInt("01"));
	   int b[]={1,2,3,7,8};//1,2,3为一组连号  7,8为一组连号
	   int c[]={1,2,3,7,9};
	   int d[]={1,3,6,7,9};//6,7为一组连号
	   int e[]={1,3,5,7,9};
	   int f[]={1,3,5,6,7};
	   int g[]={4,6,7,9,10};
	   int hh[]={1,6,7,8,10};
	   int k[]={1,6,7,8,9};
	   int l[]={4,7,6,5,9};
	   int a[]={1,2,4,5,7};
	   int temp=0;
	   int flag1=0;
	   int flag2=0;
	  // Arrays.sort(b);
	   //for(int u=0;u<b.length;u++){
		 //  System.out.println("u= "+b[u]);
	  // }
	   //冒泡排序
	   for(int i=0;i<a.length-1;i++){
		   for(int j=i+1;j<a.length;j++){
			   if(a[i]>a[j]){
				   temp=a[i];
				   a[i]=a[j];
				   a[j]=temp;
				   
			   }
			   
		   }
	   }
	   ArrayList<HashMap<Integer, Object>> list=new ArrayList<HashMap<Integer,Object>>();
	   HashMap<Integer, Object> map=new HashMap<Integer, Object>();
	   for(int h=0;h<a.length-1;h++){
		   if(a[h]+1==a[h+1]){
			   System.out.println("enen= "+map);
			   map.put(h, a[h]);
			  if(h+1==4){
				  System.out.println("okok");
				  map.put(a[h+1], a[h+1]);
				list.add(map);
			  }
			   System.out.println("nn= "+map);
			   
		   }else{
			   if(h>0&&a[h]-1==a[h-1]){
				   map.put(h, a[h]);
			   }
			   System.out.println("3= "+map);
			   System.out.println("map.size "+map.size());
			   if(map.size()!=0){
				   System.out.println("map size "+map.size());
				   list.add(map);
			   }
			   map=new HashMap<Integer, Object>();
		   }
		   //list.add(map);
	   }
	   System.out.println(map);
	   System.out.println("连号组数= "+list.size());
	   return list.size();
   }
   
   
   //连号组数参考答案
   public static void sayHellos(){
	   int c[]={1,2,4,5,6};
	   int b[]={1,2,4,6,7};
	   int a[]={1,2,3,6,8};
	   int temp=0;
	   for(int i=0;i<a.length-1;i++){
		   for(int j=i+1;j<a.length;j++){
			   if(a[i]>a[j]){
				   temp=a[i];
				   a[i]=a[j];
				   a[j]=temp;
			   }
		   }
	   }
	   for(int i=0;i<a.length;i++){
		  System.out.println("hehe "+a[i]);
	   }
	   ArrayList<HashMap<Integer, Integer>>  ht=new ArrayList<HashMap<Integer, Integer>>();
	   HashMap<Integer, Integer> mp=new HashMap<Integer, Integer>();
	   for(int i=0;i<a.length;i++){
		   //System.out.println(a[i]);
		   if(i<a.length-1){
			   if(a[i]+1==a[i+1]){
				   mp.put(a[i], a[i]);
			   }else{
				   if(i>0&&a[i]-1==a[i-1]){
					   mp.put(a[i], a[i]);
				   }
				   if(mp.size()!=0){
				   System.out.println(mp);
				   ht.add(mp);}
				   mp=new HashMap<Integer, Integer>();
			   }
		   }else{
			   if(a[i]-1==a[i-1]){
				   mp.put(a[i], a[i]);
			   }
			   if(mp.size()!=0){
				   System.out.println(mp);
				   ht.add(mp); 
			   }
		   }
		   
	   }
	   System.out.println(ht.size());
	   
   }
 //连号组合
   public static void lt(){
      String bn[]={"02","01","03","06","05"};
	   
	   Arrays.sort(bn);
	   for(int t=0;t<bn.length;t++){
		   System.out.println("bn = "+bn[t]);
		   
	   }
	   
	   System.out.println("ahahah"+Integer.parseInt("01"));
	   int b[]={1,2,3,7,8};//1,2,3为一组连号  7,8为一组连号
	   int c[]={1,2,3,7,9};
	   int d[]={1,3,6,7,9};//6,7为一组连号
	   int e[]={1,3,5,7,9};
	   int f[]={1,3,5,6,7};
	   int g[]={4,6,7,9,10};
	   int hh[]={1,6,7,8,10};
	   int k[]={1,6,7,8,9};
	   int l[]={4,7,6,5,9};
	   int a[]={1,3,5,7,9};
	   int temp=0;
	   int flag1=0;
	   int flag2=0;
	   Arrays.sort(b);
	  
	  
	   ArrayList<HashMap<Integer, Object>> list=new ArrayList<HashMap<Integer,Object>>();
	   HashMap<Integer, Object> map=new HashMap<Integer, Object>();
	   for(int h=0;h<a.length-1;h++){
		   if(a[h]+1==a[h+1]){
			   System.out.println("enen= "+map);
			   map.put(h, a[h]);
			  if(h+1==4){
				  System.out.println("okok");
				  map.put(a[h+1], a[h+1]);
				list.add(map);
			  }
			   System.out.println("nn= "+map);
			   
		   }else{
			   if(h>0&&a[h]-1==a[h-1]){
				   map.put(h, a[h]);
			   }
			   System.out.println("3= "+map);
			   System.out.println("map.size "+map.size());
			   if(map.size()!=0){
				   //System.out.println(map);
				   list.add(map);
			   }
			   map=new HashMap<Integer, Object>();
		   }
		   //list.add(map);
	   }
	   System.out.println(map);
	   System.out.println("haha= "+list.size());
	   
   }
   
    
}
